import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinesweeperBoard {

    private List<String> inputBoard;
    private static final String MINE_SIGN = "*";

    public MinesweeperBoard(List<String> inputBoard) {
        this.inputBoard = inputBoard;
    }

    public List<String> withNumbers() {
        if (this.inputBoard.isEmpty()) {
            return this.inputBoard;
        }

        String[][] array = this.inputBoard.stream()
                                          .map(s -> s.split(""))
                                          .toArray(String[][]::new);

        int row = array.length;
        int column = array[0].length;
        String[][] result = new String[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = array[i][j];
                if (array[i][j].equals(MINE_SIGN)) {
                    continue;
                }
                int count = 0;
                /**
                 * begin to sweeper mine.
                 */
                if (i > 0 && array[i - 1][j].equals(MINE_SIGN)) {
                    count++;
                }

                if (i < row - 1 && array[i + 1][j].equals(MINE_SIGN)) {
                    count++;
                }
                if (j > 0 && array[i][j - 1].equals(MINE_SIGN)) {
                    count++;
                }
                if (j < column - 1 && array[i][j + 1].equals(MINE_SIGN)) {
                    count++;
                }

                if (i > 0 && j > 0 && array[i - 1][j - 1].equals(MINE_SIGN)) {
                    count++;
                }
                if (i > 0 && j < column - 1 && array[i - 1][j + 1].equals(MINE_SIGN)) {
                    count++;
                }
                if (i < row - 1 && j > 0 && array[i + 1][j - 1].equals(MINE_SIGN)) {
                    count++;
                }
                if (i < row - 1 && j < column - 1 && array[i + 1][j + 1].equals(MINE_SIGN)) {
                    count++;
                }
                if (count != 0) {
                    result[i][j] = String.valueOf(count);
                }
            }
        }

        return Arrays.stream(result)
                     .map(MinesweeperBoard::toString)
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> inputBoard = Arrays.asList("   ", " * ", "   ");
        MinesweeperBoard minesweeperBoard = new MinesweeperBoard(inputBoard);
        List<String> result = minesweeperBoard.withNumbers();
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String toString(Object[] a) {
        if (a == null) {
            return "null";
        }

        int iMax = a.length - 1;
        if (iMax == -1) {
            return "";
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.toString();
            }
        }
    }
}
