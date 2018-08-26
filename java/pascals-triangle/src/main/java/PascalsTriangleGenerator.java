public class PascalsTriangleGenerator {

    public int[][] generateTriangle(int level) {
        if (level < 0) {
            throw new IllegalArgumentException();
        }

        int[][] result = new int[level][];
        int index = 0;

        for (int i = 1; i <= level; i++) {
            result[index++] = getPascalLine(i);
        }
        return result;
    }

    /**
     * Reference <a href="https://rosettacode.org/wiki/Pascal%27s_triangle#Java"/>
     */
    private static int[] getPascalLine(int n) {
        int[] result = new int[n];
        int index = 0;

        if (n < 1) {
            return result;
        }

        int m = 1;
        result[index++] = m;

        for (int j = 1; j < n; j++) {
            m = m * (n - j) / j;
            result[index++] = m;
        }

        return result;
    }

}
