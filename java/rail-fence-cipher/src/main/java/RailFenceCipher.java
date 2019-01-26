import java.util.ArrayList;
import java.util.List;

public class RailFenceCipher {

    private int rowSize;

    public RailFenceCipher(int rowSize) {
        this.rowSize = rowSize;
    }

    public String getEncryptedData(String rawText) {
        int vSize = this.rowSize * 2 - 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.rowSize; i++) {
            for (int j = i; j < rawText.length(); j += vSize) {
                result.append(rawText.charAt(j));
                if (i != 0 && i != (this.rowSize - 1) && ((j - i) + (vSize - i) < rawText.length())) {
                    result.append(rawText.charAt((j - i) + (vSize - i)));
                }
            }
        }
        return result.toString();
    }

    public String getDecryptedData(String encryptedText) {
        List<Integer>[] pattern = getFencePattern(encryptedText.length());

        StringBuilder result = new StringBuilder();
        result.setLength(encryptedText.length());
        int index = 0;
        for (List<Integer> line : pattern) {
            for (int col : line) {
                result.setCharAt(col, encryptedText.charAt(index));
                index++;
            }
        }
        return result.toString();
    }

    private List<Integer>[] getFencePattern(int messageSize) {
        @SuppressWarnings("unchecked")
        List<Integer>[] pattern = new List[this.rowSize];
        for (int i = 0; i < pattern.length; i++) {
            pattern[i] = new ArrayList<>();
        }
        int row = 0;
        int rowOffset = 1;
        for (int col = 0; col < messageSize; col++) {
            pattern[row].add(col);

            row += rowOffset;
            if (!(row >= 0 && row < pattern.length)) {
                rowOffset *= -1;
                row += rowOffset * 2;
            }
        }
        return pattern;
    }
}
