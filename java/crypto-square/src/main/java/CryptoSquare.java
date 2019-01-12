/**
 * @author craneyuan
 */
public class CryptoSquare {

    private String originalText;
    private String cryptedText;

    public CryptoSquare(String originalText) {
        this.originalText = originalText;
    }

    public String getCiphertext() {
        if (this.cryptedText != null) {
            return this.cryptedText;
        }
        String result = this.originalText.replaceAll("[^a-zA-Z\\d]", "")
                                         .toLowerCase();
        int len = result.length();
        double lenSqrt = Math.sqrt(len);
        int row = (int) Math.floor(lenSqrt);
        int col = (int) Math.ceil(lenSqrt);

        if (len > Math.multiplyExact(row, col)) {
            row = col;
        }

        char[][] array = new char[row][col];

        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (k < len) {
                    array[i][j] = result.charAt(k++);
                } else {
                    array[i][j] = ' ';
                }
            }
        }

        StringBuilder sb = new StringBuilder(len);
        String prefix = "";
        for (int i = 0; i < col; i++) {
            sb.append(prefix);
            for (int j = 0; j < row; j++) {
                sb.append(array[j][i]);
            }
            prefix = " ";
        }

        this.cryptedText = sb.toString();
        return this.cryptedText;
    }

}
