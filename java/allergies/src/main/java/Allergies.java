import java.util.ArrayList;
import java.util.List;

public class Allergies {

    private List<Allergen> allergenList;

    public Allergies(int score) {
        this.allergenList = new ArrayList<>();

        char[] binary = Integer.toBinaryString(score)
                               .toCharArray();

        Allergen[] allergens = Allergen.values();
        int size = binary.length;

        for (int i = size - 1; i >= 0 && (size - i <= 8); i--) {
            if (binary[i] == '1') {
                allergenList.add(allergens[size - i - 1]);
            }
        }
    }

    public boolean isAllergicTo(Allergen peanuts) {
        return allergenList.contains(peanuts);
    }

    public List<Allergen> getList() {
        return allergenList;
    }

}
