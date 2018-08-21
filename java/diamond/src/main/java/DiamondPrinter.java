import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    private char base = 'A';

    List<String> printToList(char a) {
        List<String> result = new ArrayList<>();
        int size = a - base + 1;

        if (size == 1) {
            result.add(getLineA(0));
            return result;
        }

        result.add(getLineA(size - 1));
        result.addAll(getLineToMax(size));
        result.addAll(getLineToMin(size));
        result.add(getLineA(size - 1));

        return result;
    }

    private String getLineA(int side) {
        StringBuilder line = new StringBuilder();

        line.append(getSpace(side))
            .append('A')
            .append(getSpace(side));

        return line.toString();
    }

    private List<String> getLineToMax(int size) {
        List<String> result = new ArrayList<>();

        StringBuilder line = new StringBuilder();
        int side = size - 2;
        int inside = 1;
        for (int i = 1; i < size; i++) {
            String sideSpace = getSpace(side--);
            line.append(sideSpace)
                .append((char) (base + i))
                .append(getSpace(inside))
                .append((char) (base + i))
                .append(sideSpace);
            inside += 2;
            result.add(line.toString());
            line.setLength(0);
        }
        return result;
    }

    private List<String> getLineToMin(int size) {
        List<String> result = new ArrayList<>();

        StringBuilder line = new StringBuilder();
        int side = 1;
        int inside;
        for (int i = size - 2; i > 0; i--) {
            inside = size * 2 - 1 - side * 2 - 2;
            String sideSpace = getSpace(side++);
            line.append(sideSpace)
                .append((char) (base + i))
                .append(getSpace(inside))
                .append((char) (base + i))
                .append(sideSpace);
            result.add(line.toString());
            line.setLength(0);
        }
        return result;
    }

    private String getSpace(int amount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            result.append(" ");
        }
        return result.toString();
    }
}
