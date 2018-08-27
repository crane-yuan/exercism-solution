import java.util.ArrayList;
import java.util.List;

public class Transpose {

    public String transpose(String input) {
        StringBuilder result = new StringBuilder();
        int maxColumnSize = Integer.MIN_VALUE;
        List<String[]> inputList = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            inputList.add(line.split(""));
            if (line.length() > maxColumnSize) {
                maxColumnSize = line.length();
            }
        }

        int rowSize = inputList.size();
        int columnSize = maxColumnSize;

        String prefix = "";
        for (int i = 0; i < columnSize; i++) {
            result.append(prefix);
            for (int j = 0; j < rowSize; j++) {
                if (inputList.get(j).length > i) {
                    result.append(inputList.get(j)[i]);
                } else {
                    int maxLine = i;
                    for (int k = j; k < rowSize; k++) {
                        if (inputList.get(k).length > maxLine) {
                            maxLine = inputList.get(k).length;
                        }
                        if (maxLine > i) {
                            result.append(" ");
                            break;
                        }
                    }
                }
            }
            prefix = "\n";
        }
        return result.toString();
    }
}
