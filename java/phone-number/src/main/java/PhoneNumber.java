public class PhoneNumber {

    private static String wrongLengthExceptionMessage = "Number must be 10 or 11 digits";
    private static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage = "Can only have 11 digits if number starts with '1'";
    private static String illegalCharacterExceptionMessage =
            "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.";
    private static String illegalAreaOrExchangeCodeMessage = "Illegal Area Or Exchange Code. Only 2-9 are valid digits";

    private String number;

    public PhoneNumber(String input) {
        if (!input.chars()
                  .allMatch(c -> Character.isDigit(c) || " ()-.+".indexOf(c) >= 0)) {
            throw new IllegalArgumentException(illegalCharacterExceptionMessage);
        }

        number = input.replaceAll("[^\\d]", "");

        int len = number.length();
        if (len != 10 && len != 11) {
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        }
        if (len == 11 && !number.startsWith("1")) {
            throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
        }

        number = number.substring(len - 10);

        if (numChar2int(number.charAt(0)) < 2 || numChar2int(number.charAt(3)) < 2) {
            throw new IllegalArgumentException(illegalAreaOrExchangeCodeMessage);
        }
    }

    public String getNumber() {
        return this.number;
    }

    private int numChar2int(char num) {
        return num - '0';
    }
}
