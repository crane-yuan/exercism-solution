import java.util.stream.Stream;

public class PangramChecker {

    public boolean isPangram(String input) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        return Stream.of(alphabet.split(""))
                     .allMatch(input.toLowerCase()::contains);
    }

}
