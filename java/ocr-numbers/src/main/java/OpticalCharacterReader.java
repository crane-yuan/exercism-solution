import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpticalCharacterReader {

    public String parse(List<String> list) {

        int row = list.size();
        int column = list.get(0)
                         .length();
        if (row % 4 != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }
        if (column % 3 != 0) {
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }

        List<List<String>> matrix = new ArrayList<>();
        for (int i = 0; i < row; i += 4) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                temp.add(list.get(i + j));
            }
            matrix.add(temp);
        }

        List<String> result = new ArrayList<>();

        for (List<String> line : matrix) {
            StringBuilder sb = new StringBuilder();
            List<List<String>> nums = splitColumn(line);
            for (List<String> num : nums) {
                sb.append(convertOCR(num));
            }
            result.add(sb.toString());
        }
        return String.join(",", result);
    }

    private static String convertOCR(List<String> singleNumList) {
        // @formatter:off
        List<String> numList =Arrays.asList(
                "    _  _     _  _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|| |",
                "  ||_  _|  | _||_|  ||_| _||_|",
                "                              "
        );
        // @formatter:on

        List<List<String>> matrix = splitColumn(numList);
        for (int i = 0; i < matrix.size(); i++) {
            List<String> num = matrix.get(i);
            if (checkListString(num, singleNumList)) {
                return String.valueOf((i + 1) % 10);
            }
        }
        return "?";
    }

    private static List<List<String>> splitColumn(List<String> list) {
        int column = list.get(0)
                         .length();

        List<List<String>> matrix = new ArrayList<>();
        for (int i = 0; i < column; i += 3) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                temp.add(list.get(j)
                             .substring(i, i + 3));
            }
            matrix.add(temp);
        }
        return matrix;
    }

    private static boolean checkListString(List<String> list1, List<String> list2) {
        return list1.equals(list2);
    }

}
