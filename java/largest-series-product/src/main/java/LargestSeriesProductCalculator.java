import java.util.Arrays;

class LargestSeriesProductCalculator {

    private String numberString;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.chars()
                        .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.numberString = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        if (numberOfDigits > this.numberString.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        if (numberOfDigits == 0) {
            return 1L;
        }

        int[] array = Arrays.stream(this.numberString.split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        long maxProduct = 0L;
        for (int i = 0; i <= array.length - numberOfDigits; i++) {
            if (array[i] == 0) {
                continue;
            }
            long product = array[i];

            for (int j = 1; j < numberOfDigits; j++) {
                product *= array[i + j];
            }
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }
}
