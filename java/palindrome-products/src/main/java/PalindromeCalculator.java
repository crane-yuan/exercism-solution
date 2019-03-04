import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;

public class PalindromeCalculator {

    public SortedMap<Long, List<List<Integer>>> getPalindromeProductsWithFactors(int a, int b) {
        if (a > b) {
            throw new IllegalArgumentException(String.format("invalid input: min is %s and max is %s", a, b));
        }

        SortedMap<Long, List<List<Integer>>> palindromes = new TreeMap<>();
        for (int i = a; i <= b; i++) {
            for (int j = i; j <= b; j++) {
                Long num = Long.valueOf(i * j);
                if (isPalindrome(num)) {
                    if (!palindromes.containsKey(num)) {
                        palindromes.put(num, new ArrayList<>());
                    }
                    palindromes.get(num)
                               .add(Arrays.asList(i, j));
                }
            }
        }

        if (palindromes.isEmpty()) {
            throw new NoSuchElementException(String.format("no palindrome with factors in the range %s to %s", a, b));
        }
        return palindromes;
    }

    private boolean isPalindrome(long num) {
        char[] nums = Long.toString(num)
                          .toCharArray();

        int i = 0;
        int j = nums.length - 1;
        do {
            if (nums[i++] != nums[j--]) {
                return false;
            }
        } while (i < j);
        return true;
    }
}
