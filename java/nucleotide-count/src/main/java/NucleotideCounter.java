import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NucleotideCounter {

    static final List<Character> DNA_SOURCE = Arrays.asList('A', 'C', 'G', 'T');

    private String dna;
    private List<Character> dnaList;

    NucleotideCounter(String dna) {
        List<Character> dnaList = dna.chars()
                                     .mapToObj(i -> (char) i)
                                     .collect(Collectors.toList());
        dnaList.stream()
               .distinct()
               .forEach(key -> {
                   if (!DNA_SOURCE.contains(key)) {
                       throw new IllegalArgumentException();
                   }
               });
        this.dna = dna;
        this.dnaList = dnaList;
    }

    Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> result = new HashMap<>();

        Map<Character, Long> counted = dnaList.stream()
                                              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        DNA_SOURCE.forEach(key -> {
            Long value = counted.get(key);
            result.put(key, Math.toIntExact(value == null ? 0 : value));
        });
        return result;
    }

}
