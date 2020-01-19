public class Item {

    private int value;
    private int weight;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
