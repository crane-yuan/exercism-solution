import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

class DnDCharacter {

    private Random random = SecureRandom.getInstanceStrong();

    private int strength = ability();
    private int dexterity = ability();
    private int constitution = ability();
    private int intelligence = ability();
    private int wisdom = ability();
    private int charisma = ability();

    public DnDCharacter() throws NoSuchAlgorithmException {
        // throw NoSuchAlgorithmException if no algorithm is available
    }

    int ability() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += getRandomNumberInRange(1, 6);
        }
        return sum;
    }

    private int getRandomNumberInRange(int min, int max) {
        return random.ints(min, (max + 1))
                     .findFirst()
                     .getAsInt();

    }

    public int getStrength() {
        return this.strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public int getCharisma() {
        return this.charisma;
    }

    public int getHitpoints() {
        return 10 + modifier(this.constitution);
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }
}
