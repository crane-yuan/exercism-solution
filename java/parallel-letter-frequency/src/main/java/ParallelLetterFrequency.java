import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParallelLetterFrequency {

    private String rawText;

    public ParallelLetterFrequency(String rawText) {
        this.rawText = rawText;
    }

    public Map<Integer, Integer> letterCounts() {

        return this.rawText.toLowerCase()
                           .chars()
                           .parallel()
                           .filter(Character::isAlphabetic)
                           .boxed()
                           .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(ch -> 1)));

    }
}
