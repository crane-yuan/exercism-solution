import java.util.ArrayList;
import java.util.List;

public class Series {
    private String originalStr;

    public Series(String originalStr) {
        this.originalStr = originalStr;
    }

    public List<String> slices(int slice) {
        if (slice > this.originalStr.length()) {
            throw new IllegalArgumentException("Slice size is too big.");
        } else if (slice <= 0) {
            throw new IllegalArgumentException("Slice size is too small.");
        }

        List<String> result = new ArrayList<>();
        String[] array = this.originalStr.split("");
        for (int i = 0; i <= array.length - slice; i++) {
            StringBuilder stringBuilder = new StringBuilder(slice);
            for (int j = 0; j < slice; j++) {
                stringBuilder.append(array[i + j]);
            }
            result.add(stringBuilder.toString());
            stringBuilder.setLength(0);             // a trick for memory performance
        }
        return result;
    }
}
