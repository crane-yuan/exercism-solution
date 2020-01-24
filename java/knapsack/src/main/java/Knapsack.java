import java.util.ArrayList;

public class Knapsack {

    public int maximumValue(int weightLimit, ArrayList<Item> itemList) {
        return maximumValueDp2(weightLimit, itemList);
    }

    /**
     * V(i,j)=Max(V(i-1,j), V(i-1,j-w(i))+vi);
     */
    public int maximumValueDp(int weightLimit, ArrayList<Item> itemList) {
        int[][] V = new int[itemList.size() + 1][weightLimit + 1];
        for (int i = 1; i <= itemList.size(); i++) {
            for (int j = 1; j <= weightLimit; j++) {
                if (j < itemList.get(i - 1)
                                .getWeight()) {
                    V[i][j] = V[i - 1][j];
                } else {
                    V[i][j] = Math.max(V[i - 1][j], (V[i - 1][j - itemList.get(i - 1)
                                                                          .getWeight()] + itemList.get(i - 1)
                                                                                                  .getValue()));
                }
            }
        }
        return V[itemList.size()][weightLimit];
    }

    public int maximumValueDp2(int weightLimit, ArrayList<Item> itemList) {
        int[] V = new int[weightLimit + 1];
        for (int i = 0; i < itemList.size(); i++) {
            for (int j = weightLimit; j >= 0; j--) {
                if (j >= itemList.get(i)
                                 .getWeight()) {
                    V[j] = Math.max(V[j], (V[j - itemList.get(i)
                                                         .getWeight()] + itemList.get(i)
                                                                                 .getValue()));
                }
            }
        }
        return V[weightLimit];
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
