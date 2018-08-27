public class Queen {

    private int x;
    private int y;

    public Queen(int x, int y) {
        if (x > 7) {
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        }
        if (y > 7) {
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }

        if (x < 0) {
            throw new IllegalArgumentException("Queen position must have positive row.");
        }
        if (y < 0) {
            throw new IllegalArgumentException("Queen position must have positive column.");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
