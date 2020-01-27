import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ChangeCalculator {

    private List<Integer> coinList;

    public ChangeCalculator(List<Integer> coinList) {
        this.coinList = coinList;
    }

    public List<Integer> computeMostEfficientChange(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }
        Map<Integer, List<Integer>> value2coins = new HashMap<>();
        value2coins.put(0, Collections.emptyList());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int value = queue.poll();
            if (value == target) {
                return value2coins.get(value);
            }

            for (Integer coin : coinList) {
                int nextValue = value + coin;
                if (nextValue <= target && !value2coins.containsKey(nextValue)) {
                    List<Integer> nextCoins = new ArrayList<>(value2coins.get(value));
                    nextCoins.add(coin);

                    value2coins.put(nextValue, nextCoins);
                    queue.offer(nextValue);
                }
            }
        }
        throw new IllegalArgumentException(String.format("The total %d cannot be represented in the given currency.", target));
    }

    /**
     * https://www.cnblogs.com/hapjin/p/5578852.html
     * c[i,j]= min{c[i-1,j] , c[i, j-coinsValues[i]] + 1}
     */
    public List<Integer> computeMostEfficientChange2(int target) {
        int[][] c = new int[this.coinList.size() + 1][target + 1];

        for (int i = 0; i <= this.coinList.size(); i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i <= target; i++) {
            c[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= this.coinList.size(); i++) {
            for (int j = 1; j <= target; j++) {
                if (j < this.coinList.get(i - 1)) {
                    c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = Math.min(c[i - 1][j], c[i][j - this.coinList.get(i - 1)] + 1);
                }
            }
        }

        for (int[] i : c) {
            for (int i1 : i) {
                System.out.print(i1 + "\t");
            }
            System.out.println();
        }
        return null;
    }
}
