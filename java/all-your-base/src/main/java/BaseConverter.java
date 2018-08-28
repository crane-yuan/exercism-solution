import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseConverter {

    private int base;
    private int[] value;
    private static final int DECIMAL = 10;

    public BaseConverter(int base, int[] value) {
        if (base < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }
        for (int a : value) {
            if (a < 0) {
                throw new IllegalArgumentException("Digits may not be negative.");
            }
            if (a >= base) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }
        }
        this.base = base;
        this.value = value;
    }

    public int[] convertToBase(int toBase) {
        if (toBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }
        if (base == toBase) {
            return value;
        }

        int decimal = toDecimal(value, base);

        return fromDecimal(decimal, toBase);
    }

    /**
     * convert to decimal by base
     */
    private int toDecimal(int[] value, int base) {
        int size = value.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (value[i] != 0) {
                result += value[i] * Math.pow(base, size - i - 1);
            }
        }

        return result;
    }

    /**
     * convert from decimal to base
     */
    private int[] fromDecimal(int value, int base) {
        if (value == 0) {
            return new int[] {0};
        }

        List<Integer> list = new ArrayList<>();
        while (value > 0) {
            list.add(value % base);
            value /= base;
        }
        Collections.reverse(list);

        return list.parallelStream()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }

}
