import java.util.ArrayList;
import java.util.List;

public class Allergies {

    private int score;
    private List<Allergen> allergies;

    public Allergies(int score) {
        this.score = score;
        this.allergies = new ArrayList<>();

        char[] binary = Integer.toBinaryString(score)
                               .toCharArray();

        Allergen[] allergens = Allergen.values();
        int size = binary.length;

        for (int i = size - 1; i >= 0 && (size - i <= 8); i--) {
            if (binary[i] == '1') {
                allergies.add(allergens[size - i - 1]);
            }
        }
    }

    public boolean isAllergicTo(Allergen peanuts) {
        return allergies.contains(peanuts);
    }

    public List<Allergen> getList() {
        return allergies;
    }

}
