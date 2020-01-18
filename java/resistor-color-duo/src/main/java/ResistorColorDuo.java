import java.util.stream.IntStream;

class ResistorColorDuo {
    private static final String[] COLORS = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int value(String[] colors) {
        int maxNum = Math.min(colors.length, 2);
        int sum = 0;
        for (int i = maxNum - 1; i >= 0; i--) {
            sum += colorCode(colors[i]) * Math.pow(10, maxNum - i - 1);
        }
        return sum;
    }

    int colorCode(String color) {
        return IntStream.range(0, COLORS.length)
                        .filter(i -> COLORS[i].equals(color))
                        .findAny()
                        .getAsInt();
    }

}
