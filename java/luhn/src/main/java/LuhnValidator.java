import java.util.Arrays;

class LuhnValidator {

    boolean isValid(String candidate) {
        boolean result = false;
        candidate = candidate.replace(" ", "");

        if (candidate.length() < 2) {
            return result;
        }

        /*
        if (!candidate.matches("^[\\d]+$")) {
            return result;
        }
        */
        if (!candidate.chars()
                      .allMatch(Character::isDigit)) {
            return result;
        }

        int[] nums = Arrays.stream(candidate.split(""))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        int checkSum = 0;
        boolean odd = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            checkSum += odd ? nums[i] : getDigital(nums[i] * 2);
            odd = !odd;
        }
        if (checkSum % 10 == 0) {
            result = true;
        }
        return result;
    }

    private int getDigital(int num) {
        return num > 9 ? (num - 9) : num;
    }
}
