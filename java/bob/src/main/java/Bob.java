import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author craneyuan
 */
public class Bob {

    private String fine = "Fine. Be that way!";
    private String whatever = "Whatever.";
    private String sure = "Sure.";
    private String amazed = "Whoa, chill out!";
    private String complained = "Calm down, I know what I'm doing!";
    private char questionSign = '?';

    public String hey(String phrase) {
        String temp = phrase.replaceAll("[\\s,]+", "");

        if (temp.equals("")) {
            return fine;
        }

        char lastChar = temp.charAt(temp.length() - 1);

        if (isNumeric(temp)) {
            return whatever;
        }

        if (temp.equals(temp.toUpperCase())) {
            if (lastChar == questionSign) {
                if (hasSpecialChar(temp.substring(0, temp.length() - 1))) {
                    return sure;
                }
                return complained;
            }

            return amazed;
        }

        if (lastChar == questionSign) {
            return sure;
        }

        return whatever;
    }

    private boolean hasSpecialChar(String name) {
        Pattern p = Pattern.compile("[^a-zA-Z]");
        Matcher m = p.matcher(name);
        return m.find();
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(.\\d+)?");
    }

}
