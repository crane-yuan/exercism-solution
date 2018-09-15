class CollatzCalculator {

    int computeStepCount(int start) {
        if (start < 1) {
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }
        int step = 0;

        while (start != 1) {
            if (isEven(start)) {
                start >>= 1;
            } else {
                start = start * 3 + 1;
            }
            step++;
        }
        return step;
    }

    private boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
