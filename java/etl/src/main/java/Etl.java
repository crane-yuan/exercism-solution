import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (Integer key : old.keySet()) {
            List<String> valueList = old.get(key);
            for (String str : valueList) {
                resultMap.put(str.toLowerCase(), key);
            }
        }
        return resultMap;
    }
}
