import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flattener {

    public List<Object> flatten(List<Object> lists) {
        return flattenToStream(lists).filter(Objects::nonNull)
                                     .collect(Collectors.toList());
    }

    /**
     * Reference <a href="https://rosettacode.org/wiki/Flatten_a_list#Java"/>
     */
    private static Stream<Object> flattenToStream(List<?> list) {
        return list.stream()
                   .flatMap(item -> item instanceof List<?> ? flattenToStream((List<?>) item) : Stream.of(item));
    }

}
