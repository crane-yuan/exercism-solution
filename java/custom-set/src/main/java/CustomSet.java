import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomSet<E> {

    private HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public CustomSet(Collection<? extends E> c) {
        map = new HashMap<>(Math.max((int) (c.size() / .75f) + 1, 16));
        addAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        CustomSet<E> other = (CustomSet<E>) obj;
        return isSubset(other) && other.isSubset(this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(E s) {
        return map.containsKey(s);
    }

    public boolean isSubset(CustomSet<E> secondCustomSet) {
        return map.keySet()
                  .containsAll(secondCustomSet.map.keySet());
    }

    public boolean isDisjoint(CustomSet<E> secondCustomSet) {
        return map.keySet()
                  .stream()
                  .allMatch(e -> !secondCustomSet.contains(e));
    }

    public CustomSet<E> getIntersection(CustomSet<E> secondCustomSet) {
        return new CustomSet<>(map.keySet()
                                  .stream()
                                  .filter(secondCustomSet::contains)
                                  .collect(Collectors.toList()));
    }

    public CustomSet<E> getDifference(CustomSet<Object> secondCustomSet) {
        return new CustomSet<>(map.keySet()
                                  .stream()
                                  .filter(e -> !secondCustomSet.contains(e))
                                  .collect(Collectors.toList()));
    }

    public CustomSet<E> getUnion(CustomSet<E> secondCustomSet) {
        return new CustomSet<>(Stream.concat(map.keySet()
                                                .stream(), secondCustomSet.map.keySet()
                                                                              .stream())
                                     .collect(Collectors.toList()));
    }
}
