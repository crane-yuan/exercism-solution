import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {

    private int number;
    private int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        int sum;
        Set<Integer> result = new HashSet<>();

        for (int i = 1; i < number; i++) {
            for (int j = 0; j < set.length; j++) {
                if (i % set[j] == 0) {
                    result.add(i);
                }
            }
        }

        sum = result.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        return sum;
    }

}
