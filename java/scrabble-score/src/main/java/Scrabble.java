import java.util.HashMap;
import java.util.Map;

public class Scrabble {
    private int result = 0;

    Scrabble(String word) {
        Map<String, Integer> dict = new HashMap<>();
        dict.put("AEIOULNRST", 1);
        dict.put("FHVWY", 4);
        dict.put("BCMP", 3);
        dict.put("DG", 2);
        dict.put("JX", 8);
        dict.put("QZ", 10);
        dict.put("K", 5);

        for (char letter : word.toUpperCase()
                               .toCharArray()) {
            for (Map.Entry<String, Integer> entry : dict.entrySet()) {
                if (entry.getKey()
                         .contains(Character.toString(letter))) {
                    result += entry.getValue();
                }
            }
        }
    }

    int getScore() {
        return result;
    }
}