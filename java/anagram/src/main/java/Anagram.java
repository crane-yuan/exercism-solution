import java.util.ArrayList;
import java.util.List;

public class Anagram {

    private String word;

    public Anagram(String word) {
        this.word = word.toLowerCase();
    }

    public List<String> match(List<String> phrase) {
        List<String> result = new ArrayList<>();

        for (String tempWord : phrase) {
            if (isAnagram(this.word, tempWord)) {
                result.add(tempWord);
            }
        }
        return result;
    }

    private static boolean isAnagram(String s1, String s2) {

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.equals(s2)) {
            return false;
        }

        int[] nums = new int[26];

        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();

        int s1Length = s1Char.length;
        int s2Length = s2Char.length;

        if (s1Length != s2Length) {
            return false;
        }

        for (int i = 0; i < s1Length; i++) {
            int index = s1Char[i] - 'a';
            nums[index]++;
        }

        for (int i = 0; i < s1Length; i++) {
            int index = s2Char[i] - 'a';
            nums[index]--;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return false;
            }
        }

        return true;

    }
}
