import java.util.ArrayList;
import java.util.List;

public class Allergies {

    private int score;

    Allergies(int score) {
        this.score = score;
    }

    public boolean isAllergicTo(Allergen thing) {
        return (score & thing.getScore()) == thing.getScore();
    }

    public List<Allergen> getList() {
        List<Allergen> listOfAllergens = new ArrayList<>();
        for (Allergen allergen : Allergen.values()) {
            if (isAllergicTo(allergen)) {
                listOfAllergens.add(allergen);
            }
        }
        return listOfAllergens;
    }
}
