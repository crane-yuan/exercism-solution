import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Matrix {

    private String matrixAsString;
    private List<int[]> rowList = new ArrayList<>();
    private List<int[]> columnList = new ArrayList<>();

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
    }

    int[] getRow(int rowNumber) {
        if (this.rowList.isEmpty()) {
            String[] line = matrixAsString.split("\n");
            for (String str : line) {
                int[] row = Arrays.stream(str.split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
                this.rowList.add(row);
            }
        }
        return this.rowList.get(rowNumber);
    }

    int[] getColumn(int columnNumber) {
        if (this.rowList.isEmpty()) {
            getRow(0);
        }
        if (this.columnList.isEmpty()) {
            int rowSize = this.rowList.get(0).length;
            int columnSize = this.rowList.size();

            for (int i = 0; i < rowSize; i++) {
                int[] row = new int[columnSize];
                for (int j = 0; j < columnSize; j++) {
                    row[j] = this.rowList.get(j)[i];
                }
                this.columnList.add(row);
            }
        }
        return this.columnList.get(columnNumber);
    }
}
