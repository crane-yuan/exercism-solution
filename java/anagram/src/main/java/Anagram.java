import java.util.ArrayList;
import java.util.List;

public class Anagram {

    private String word;
    private boolean empty = true;

    public Anagram(String word) {
        this.word = word.toLowerCase();
    }

    public List<String> match(List<String> phrase) {
        List<String> result = new ArrayList<>();

        for (String tempWord : phrase) {
            if (isAnagram(this.word, tempWord)) {
                this.empty = false;
                result.add(tempWord);
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    private static boolean isAnagram(String s1, String s2) {

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.equals(s2)) {
            return false;
        }

        int[] nums = new int[26];

        char[] s1_char = s1.toCharArray();
        char[] s2_char = s2.toCharArray();

        int s1_length = s1_char.length;
        int s2_length = s2_char.length;

        if (s1_length != s2_length) {
            return false;
        }

        for (int i = 0; i < s1_length; i++) {
            int index = s1_char[i] - 'a';
            nums[index]++;
        }

        for (int i = 0; i < s1_length; i++) {
            int index = s2_char[i] - 'a';
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
