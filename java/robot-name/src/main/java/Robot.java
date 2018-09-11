import java.util.Random;

public class Robot {

    private String name;

    public String getName() {
        if (this.name == null) {
            this.name = generateRobotName();
        }
        return this.name;
    }

    public void reset() {
        this.name = null;
    }

    private static String generateRobotName() {
        StringBuilder result = new StringBuilder();
        result.append(getUpperLetter(2));
        for (int i = 0; i < 3; i++) {
            result.append(getRandomNumberInRange(0, 9));
        }
        return result.toString();
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1))
                .findFirst()
                .getAsInt();

    }

    private static String getUpperLetter(int length) {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 91; // letter 'Z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            buffer.append((char) getRandomNumberInRange(leftLimit, rightLimit));
        }
        return buffer.toString();
    }
}
