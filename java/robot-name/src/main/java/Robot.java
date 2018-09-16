import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Robot {

    private String name;
    private Random random = SecureRandom.getInstanceStrong();

    public Robot() throws NoSuchAlgorithmException {
        // throw NoSuchAlgorithmException if no algorithm is available
    }

    public String getName() {
        if (this.name == null) {
            this.name = generateRobotName();
        }
        return this.name;
    }

    public void reset() {
        this.name = null;
    }

    private String generateRobotName() {
        StringBuilder result = new StringBuilder();
        result.append(getUpperLetter(2));
        for (int i = 0; i < 3; i++) {
            result.append(getRandomNumberInRange(0, 9));
        }
        return result.toString();
    }

    private int getRandomNumberInRange(int min, int max) {
        return random.ints(min, (max + 1))
                     .findFirst()
                     .getAsInt();

    }

    private String getUpperLetter(int length) {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 91; // letter 'Z'
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            buffer.append((char) getRandomNumberInRange(leftLimit, rightLimit));
        }
        return buffer.toString();
    }
}
