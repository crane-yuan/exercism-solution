import java.util.Arrays;
import java.util.HashSet;

class Yacht {

    private int[] dice;
    private YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        int score = 0;
        switch (this.yachtCategory) {
            case ONES:
            case TWOS:
            case THREES:
            case FOURS:
            case FIVES:
            case SIXES:
                score = this.yachtCategory.ordinal() * count(this.dice, this.yachtCategory.ordinal());
                break;
            case CHOICE:
                score = Arrays.stream(this.dice)
                              .sum();
                break;
            case LITTLE_STRAIGHT:
                score = Arrays.stream(this.dice)
                              .sum() == 15 ? 30 : 0;
                break;
            case BIG_STRAIGHT:
                score = Arrays.stream(this.dice)
                              .sum() == 20 ? 30 : 0;
                break;
            case FULL_HOUSE:
                score = (kinds(this.dice, 4) > 0 || kinds(this.dice, 5) > 0) ?
                        0 :
                        arrayToSet(this.dice).size() != 2 ?
                                0 :
                                Arrays.stream(this.dice)
                                      .sum();
                break;
            case FOUR_OF_A_KIND:
                int num = kinds(this.dice, 4);
                score = num > 0 ? num * 4 : 0;
                break;
            case YACHT:
                int num2 = kinds(this.dice, 5);
                score = num2 > 0 ? 50 : 0;
                break;

        }
        return score;
    }

    /**
     * Count the number of #num in the array.
     */
    private int count(int[] nums, int num) {
        return Math.toIntExact(Arrays.stream(nums)
                                     .filter(a -> a == num)
                                     .count());
    }

    /**
     * @return number(1 - 6) if array contain same number bigger than #count, else 0.
     */
    private int kinds(int[] nums, int count) {
        for (int i = 1; i <= 6; i++) {
            if (count(nums, i) >= count) {
                return i;
            }
        }
        return 0;
    }

    private HashSet<Integer> arrayToSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        return hashSet;
    }
}
