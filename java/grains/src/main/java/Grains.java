import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square > 64 || square < 1) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return new BigInteger("2").pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger result = new BigInteger("0");
        for (int i = 1; i <= 64; i++) {
            result = result.add(grainsOnSquare(i));
        }
        return result;
    }

}
