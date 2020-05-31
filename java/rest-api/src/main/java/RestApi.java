import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class RestApi {

    List<User> userList = new ArrayList<>();

    public RestApi(User... users) {
        if (Objects.nonNull(users)) {
            this.userList = Arrays.stream(users)
                                  .collect(toList());
        }
    }

    public String get(String url) {
        return new JSONObject().put("users", userList)
                               .toString();
    }

    public String get(String url, JSONObject payload) {
        List<String> reqPayload = new ArrayList<>();
        for (Object o : payload.getJSONArray("users")) {
            reqPayload.add((String) o);
        }

        JSONArray result = new JSONArray();
        for (String name : reqPayload) {
            Optional<User> first = userList.parallelStream()
                                           .filter(a -> a.name()
                                                         .equals(name))
                                           .findFirst();
            if (first.isPresent()) {
                User user = first.get();
                result.put(balanceToJson(user));
            }
        }
        return new JSONObject().put("users", result)
                               .toString();
    }

    public String post(String url, JSONObject payload) {
        if ("/add".equals(url)) {
            String name = payload.getString("user");
            User user = User.builder()
                            .setName(name)
                            .build();
            this.userList.add(user);
            return balanceToJson(user).toString();
        }
        if ("/iou".equals(url)) {
            String lender = payload.getString("lender");
            String borrower = payload.getString("borrower");
            double amount = payload.getDouble("amount");

            User lendUser = userList.parallelStream()
                                    .filter(a -> a.name()
                                                  .equals(lender))
                                    .findFirst()
                                    .get();
            User borrowUser = userList.parallelStream()
                                      .filter(a -> a.name()
                                                    .equals(borrower))
                                      .findFirst()
                                      .get();

            User user1 = updateUser(lendUser, borrower, amount);
            User user2 = updateUser(borrowUser, lender, -amount);

            JSONArray result = new JSONArray();
            result.put(balanceToJson(user1));
            result.put(balanceToJson(user2));

            return new JSONObject().put("users", result)
                                   .toString();
        }
        return null;
    }

    private User updateUser(User lender, String borrower, double amount) {
        String name = lender.name();
        List<Iou> owes = lender.owes()
                               .stream()
                               .filter(iou -> !iou.name.equals(borrower))
                               .collect(toList());
        List<Iou> owedBy = lender.owedBy()
                                 .stream()
                                 .filter(iou -> !iou.name.equals(borrower))
                                 .collect(toList());

        double newIou = lender.owedBy()
                              .stream()
                              .filter(iou -> iou.name.equals(borrower))
                              .mapToDouble(iou -> iou.amount)
                              .sum() - lender.owes()
                                             .stream()
                                             .filter(iou -> iou.name.equals(borrower))
                                             .mapToDouble(iou -> iou.amount)
                                             .sum() + amount;

        if (newIou > 0) {
            owedBy.add(new Iou(borrower, newIou));
        } else if (newIou < 0) {
            owes.add(new Iou(borrower, -1 * newIou));
        }

        owedBy.sort(Comparator.comparing(i -> i.name));
        owes.sort(Comparator.comparing(i -> i.name));

        User.Builder user = User.builder();
        user.setName(name);
        owes.forEach(iou -> user.owes(iou.name, iou.amount));
        owedBy.forEach(iou -> user.owedBy(iou.name, iou.amount));

        return user.build();
    }

    private JSONObject balanceToJson(User user) {
        JSONObject json = new JSONObject().put("name", user.name());

        JSONObject owes = new JSONObject();
        user.owes()
            .forEach(iou -> owes.put(iou.name, iou.amount));
        json.put("owes", owes);

        JSONObject owedBy = new JSONObject();
        user.owedBy()
            .forEach(iou -> owedBy.put(iou.name, iou.amount));
        json.put("owedBy", owedBy);

        double balance = user.owedBy()
                             .stream()
                             .mapToDouble(iou -> iou.amount)
                             .sum() - user.owes()
                                          .stream()
                                          .mapToDouble(iou -> iou.amount)
                                          .sum();
        json.put("balance", balance);

        return json;

    }

}