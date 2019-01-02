import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
            List<String> valueList = entry.getValue();
            for (String str : valueList) {
                resultMap.put(str.toLowerCase(), entry.getKey());
            }
        }

        return resultMap;
    }
}
