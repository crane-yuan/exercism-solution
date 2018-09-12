public class SpiralMatrixBuilder {

    /**
     * Reference <a href="https://rosettacode.org/wiki/Spiral_matrix#Java"/>
     */
    public int[][] buildMatrixOfSize(int dimension) {
        int[][] spiralArray = new int[dimension][dimension];

        int numConcentricSquares = (int) Math.ceil((dimension) / 2.0);

        int j;
        int sideLen = dimension;
        int currNum = 1;

        for (int i = 0; i < numConcentricSquares; i++) {
            // do top side
            for (j = 0; j < sideLen; j++) {
                spiralArray[i][i + j] = currNum++;
            }

            // do right side
            for (j = 1; j < sideLen; j++) {
                spiralArray[i + j][dimension - 1 - i] = currNum++;
            }

            // do bottom side
            for (j = sideLen - 2; j > -1; j--) {
                spiralArray[dimension - 1 - i][i + j] = currNum++;
            }

            // do left side
            for (j = sideLen - 2; j > 0; j--) {
                spiralArray[i + j][i] = currNum++;
            }

            sideLen -= 2;
        }

        return spiralArray;

    }
}
