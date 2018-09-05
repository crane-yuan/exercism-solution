import java.util.ArrayList;
import java.util.List;

class Sieve {

    private int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> result = new ArrayList<>();
        boolean[] array = new boolean[maxPrime + 1];

        int size = (int) Math.pow(maxPrime, 0.5);

        for (int i = 2; i <= size; i++) {
            if (array[i] == false) {
                int num = (int) Math.pow(i, 2);
                for (int j = num; j <= maxPrime; j += i) {
                    array[j] = true;
                }
            }
        }

        for (int i = 2; i <= maxPrime; i++) {
            if (array[i] == false) {
                result.add(i);
            }
        }
        return result;
    }
}
