class NaturalNumber {

    private int number;

    public NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    Classification getClassification() {
        Classification classification;
        int sum = sumOfaliquot(number);
        if (sum == number) {
            classification = Classification.PERFECT;
        } else if (sum > number) {
            classification = Classification.ABUNDANT;
        } else {
            classification = Classification.DEFICIENT;
        }
        return classification;
    }

    private int sumOfaliquot(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

}
