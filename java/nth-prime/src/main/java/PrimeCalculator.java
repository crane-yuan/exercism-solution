class PrimeCalculator {

    int nth(int nth) {
        if (nth <= 0) {
            throw new IllegalArgumentException();
        }

        int cur = 2;

        for (int i = 1; i < nth; i++) {
            for (int j = cur + 1; j < Integer.MAX_VALUE; j++) {
                if (isPrime(j)) {
                    cur = j;
                    break;
                }
            }
        }

        return cur;
    }

    /**
     * Checks whether an int is prime or not.
     * Reference <a href="https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/"/>
     */
    private boolean isPrime(int n) {
        // check if n is a multiple of 2
        if (n % 2 == 0) {
            return false;
        }
        // if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
