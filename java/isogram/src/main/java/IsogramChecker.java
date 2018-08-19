import java.util.Arrays;
import java.util.List;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        List<String> list = Arrays.asList(phrase.replaceAll("[\\s-]+", "")
                                                .toLowerCase()
                                                .split(""));

        long count = list.parallelStream()
                         .distinct()
                         .count();

        return list.size() == count;
    }

}
