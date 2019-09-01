import java.util.Random;
import java.util.stream.IntStream;

public class Cipher {
    static Random random = new Random();

    String key;

    Cipher() {
        key = IntStream.range(0, 100)
                       .mapToObj(i -> (char) (random.nextInt(26) + 'a'))
                       .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                       .toString();
    }

    Cipher(String key) {
        if (key.isEmpty() || !key.chars()
                                 .allMatch(Character::isLowerCase)) {
            throw new IllegalArgumentException();
        }

        this.key = key;
    }

    String getKey() {
        return key;
    }

    String encode(String plainText) {
        if (this.key.length() < plainText.length()) {
            int multi = Math.floorDiv(plainText.length(), this.key.length());
            for (int i = 0; i < multi; i++) {
                this.key = this.key.concat(this.key);
            }
        }
        return IntStream.range(0, plainText.length())
                        .mapToObj(i -> (char) ((plainText.charAt(i) - 'a' + key.charAt(i) - 'a') % 26 + 'a'))
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString();
    }

    String decode(String cipherText) {
        if (this.key.length() < cipherText.length()) {
            int multi = Math.floorDiv(cipherText.length(), this.key.length());
            for (int i = 0; i < multi; i++) {
                this.key = this.key.concat(this.key);
            }
        }
        return IntStream.range(0, cipherText.length())
                        .mapToObj(i -> (char) ((cipherText.charAt(i) - key.charAt(i) + 26) % 26 + 'a'))
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString();
    }

}