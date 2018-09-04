import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WordCount {

    public Map<String, Integer> phrase(String word) {
        Map<String, Integer> result = new HashMap<>();

        List<String> wordList = Arrays.asList(word.split("([,.:!&@$%^]|\\s)+"));

        for (String s : wordList) {
            if (s.startsWith("'") && s.endsWith("'")) {
                s = s.substring(1, s.length() - 1);
            }
            if (s.isEmpty()) {
                continue;
            }
            s = s.toLowerCase();
            Integer count = Optional.ofNullable(result.get(s))
                                    .orElse(0) + 1;
            result.put(s, count);
        }
        return result;
    }
}
