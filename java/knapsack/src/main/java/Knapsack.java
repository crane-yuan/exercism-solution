import java.util.ArrayList;

public class Knapsack {

    public int maximumValue(int weightLimit, ArrayList<Item> itemList) {
        return maximumValueBruteForce(weightLimit, itemList);
    }

    public int maximumValueBruteForce(int weightLimit, ArrayList<Item> itemList) {
        int maxValue = 0;
        // select the combination of m numbers from n numbers.
        for (int i = 0; i < Math.pow(2, itemList.size()); i++) {
            int k = i;
            int w = 0;
            int v = 0;
            for (int j = 0; j < itemList.size() && k > 0; j++) {
                if (k % 2 == 1) {
                    v += itemList.get(j)
                                 .getValue();
                    w += itemList.get(j)
                                 .getWeight();
                }
                k = k / 2;
            }
            if (w <= weightLimit) {
                if (v > maxValue) {
                    maxValue = v;
                }
            }
        }
        return maxValue;
    }

}
