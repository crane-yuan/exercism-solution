import java.util.Collections;
import java.util.List;

public class BinarySearch<T> {

    private List<? extends Comparable<? super T>> sortedList;

    public BinarySearch(List<? extends Comparable<? super T>> sortedList) {
        this.sortedList = sortedList;
    }

    public int indexOf2(T t) {
        int index = Collections.binarySearch(sortedList, t);
        if (index < 0) {
            index = -1;
        }
        return index;
    }

    public int indexOf(T t) {
        int low = 0;
        int high = sortedList.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = sortedList.get(mid);
            int cmp = midVal.compareTo(t);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -1;  // key not found
    }
}
