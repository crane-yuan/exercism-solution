import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    private List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> result = new HashSet<>();

        if (values.isEmpty()) {
            return result;
        }

        int rowSize = values.size();
        int columnSize = values.get(0)
                               .size();
        for (int i = 0; i < rowSize; i++) {
            List<Integer> line = values.get(i);
            for (int j = 0; j < columnSize; j++) {
                int cur = line.get(j);
                boolean flag = true;
                for (int k = 0; k < columnSize; k++) {
                    if (cur < line.get(k)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int k = 0; k < rowSize; k++) {
                        if (cur > values.get(k)
                                        .get(j)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    result.add(new MatrixCoordinate(i, j));
                }
            }
        }

        return result;
    }
}
