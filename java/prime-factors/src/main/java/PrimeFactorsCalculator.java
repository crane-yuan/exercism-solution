import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeFactorsCalculator {

    public List<Long> calculatePrimeFactorsOf(Long number) {
        if (number < 2) {
            return Collections.emptyList();
        }
        List<BigInteger> list = primeDecomp(BigInteger.valueOf(number));
        List<Long> result = null;
        if (!list.isEmpty()) {
            result = list.stream()
                         .map(BigInteger::longValue)
                         .collect(Collectors.toList());
        }
        return result;
    }

    /**
     * Reference <a href="https://rosettacode.org/wiki/Prime_decomposition#Java"/>
     */
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private static final BigInteger FIVE = BigInteger.valueOf(5);

    private List<BigInteger> primeDecomp(BigInteger n) {
        if (n.compareTo(TWO) < 0) {
            return Collections.emptyList();
        }
        ArrayList<BigInteger> factors = new ArrayList<>();

        // handle even values
        while (n.and(BigInteger.ONE)
                .equals(BigInteger.ZERO)) {
            n = n.shiftRight(1);
            factors.add(TWO);
        }

        // handle values divisible by three
        while (n.mod(THREE)
                .equals(BigInteger.ZERO)) {
            factors.add(THREE);
            n = n.divide(THREE);
        }

        // handle values divisible by five
        while (n.mod(FIVE)
                .equals(BigInteger.ZERO)) {
            factors.add(FIVE);
            n = n.divide(FIVE);
        }

        // much like how we can skip multiples of two, we can also skip
        // multiples of three and multiples of five. This increment array
        // helps us to accomplish that
        int[] pattern = {4, 2, 4, 2, 4, 6, 2, 6};
        int patternIndex = 0;
        BigInteger currentTest = BigInteger.valueOf(7);
        while (!n.equals(BigInteger.ONE)) {
            while (n.mod(currentTest)
                    .equals(BigInteger.ZERO)) {
                factors.add(currentTest);
                n = n.divide(currentTest);
            }
            currentTest = currentTest.add(BigInteger.valueOf(pattern[patternIndex]));
            patternIndex = (patternIndex + 1) & 7;
        }

        return factors;
    }
}
