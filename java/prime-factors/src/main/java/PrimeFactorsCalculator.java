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
        if (list != null) {
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

    private ArrayList<BigInteger> primeDecomp(BigInteger n) {
        if (n.compareTo(TWO) < 0) {
            return null;
        }
        ArrayList<BigInteger> factors = new ArrayList<BigInteger>();

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
        int pattern_index = 0;
        BigInteger current_test = BigInteger.valueOf(7);
        while (!n.equals(BigInteger.ONE)) {
            while (n.mod(current_test)
                    .equals(BigInteger.ZERO)) {
                factors.add(current_test);
                n = n.divide(current_test);
            }
            current_test = current_test.add(BigInteger.valueOf(pattern[pattern_index]));
            pattern_index = (pattern_index + 1) & 7;
        }

        return factors;
    }
}
