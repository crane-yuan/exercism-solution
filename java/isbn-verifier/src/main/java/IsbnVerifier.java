class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        boolean result = false;
        String nums = stringToVerify.replaceAll("[^0-9X]", "");
        if (nums.length() != 10) {
            return result;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(nums.charAt(i)) * (10 - i);
        }

        char last = nums.charAt(9);
        if (last == 'X') {
            sum += 10;
        } else {
            sum += Character.getNumericValue(last);
        }

        return sum % 11 == 0;
    }

}
