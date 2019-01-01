import java.util.List;
import java.util.stream.IntStream;

public class RelationshipComputer<T> {

    Relationship computeRelationship(List<T> aList, List<T> bList) {
        if (contains(bList, aList)) {
            if (contains(aList, bList)) {
                return Relationship.EQUAL;
            } else {
                return Relationship.SUBLIST;
            }
        } else {
            if (contains(aList, bList)) {
                return Relationship.SUPERLIST;
            } else {
                return Relationship.UNEQUAL;
            }
        }
    }

    boolean contains(List<T> list, List<T> part) {

        for (int i = 0; i <= list.size() - part.size(); i++) {
            List<T> subList = list.subList(i, i + part.size());
            if (isSame(subList, part)) {
                return true;
            }
        }
        return false;
        /*return IntStream.rangeClosed(0, list.size() - part.size())
                        .anyMatch(i -> isSame(list.subList(i, i + part.size()), part));*/
    }

    boolean isSame(List<T> list1, List<T> list2) {
        return IntStream.range(0, list1.size())
                        .allMatch(i -> list1.get(i)
                                            .equals(list2.get(i)));
    }

}
