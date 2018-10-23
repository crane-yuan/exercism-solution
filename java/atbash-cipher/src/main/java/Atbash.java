import java.util.ArrayList;
import java.util.List;

public class Atbash {

    private static final int GROUP_SIZE = 5;
    private static final String PLAIN = "abcdefghijklmnopqrstuvwxyz";
    private static final String CIPHER = "zyxwvutsrqponmlkjihgfedcba";

    public String encode(String str) {
        str = stripInvalidCharacters(str.toLowerCase());
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            result.append(applyCipher(c));
        }
        return splitIntoFiveLetterWords(result.toString());
    }

    public String decode(String str) {
        str = stripInvalidCharacters(str);
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            result.append(applyCipher(c));
        }
        return result.toString();
    }

    private static char applyCipher(char input) {
        int idx = PLAIN.indexOf(input);

        return idx >= 0 ? CIPHER.toCharArray()[idx] : input;
    }

    private static String stripInvalidCharacters(String input) {
        return input.codePoints()
                    .filter(Character::isLetterOrDigit)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
    }

    private static String splitIntoFiveLetterWords(String value) {

        return String.join(" ", splitByNumber(value, GROUP_SIZE));
    }

    private static List<String> splitByNumber(String value, int size) {
        if (value == null || size <= 0) {
            return null;
        }
        List<String> words = new ArrayList<>();

        for (int i = 0; i < value.length(); i += size) {
            words.add(i + size <= value.length() ? value.substring(i, i + size) : value.substring(i));
        }
        return words;
    }
}
