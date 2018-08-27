public class QueenAttackCalculator {

    private Queen queenA;
    private Queen queenB;

    public QueenAttackCalculator(Queen queenA, Queen queenB) {
        if (queenA == null || queenB == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (queenA.getX() == queenB.getX() && queenA.getY() == queenB.getY()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.queenA = queenA;
        this.queenB = queenB;
    }

    public boolean canQueensAttackOneAnother() {
        boolean result = false;

        // same row
        if (queenA.getX() == queenB.getX()) {
            result = true;
        }

        // same column
        if (queenA.getY() == queenB.getY()) {
            result = true;
        }

        // same diagonal
        int x = Math.abs(queenA.getX() - queenB.getX());
        int y = Math.abs(queenA.getY() - queenB.getY());
        if (x == y) {
            result = true;
        }
        return result;
    }
}
