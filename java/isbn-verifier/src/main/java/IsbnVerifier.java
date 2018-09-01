class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        boolean result = false;
        String nums = stringToVerify.replaceAll("-", "");
        if (nums.length() != 10) {
            return result;
        }

        for (int i = 0; i < 9; i++) {
            if (!Character.isDigit(nums.charAt(i))) {
                return result;
            }
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (nums.charAt(i) - '0') * (10 - i);
        }

        char last = nums.charAt(9);
        if (last == 'x' || last == 'X') {
            sum += 10;
        } else if (Character.isDigit(last)) {
            sum += (last - '0');
        } else {
            return result;
        }

        return sum % 11 == 0;
    }

}
