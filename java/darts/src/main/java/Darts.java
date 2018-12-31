class Darts {

    public static final int OUTER_CIRCLE = 10;
    public static final int MIDDLE_CIRCLE = 5;
    public static final int INNER_CIRCLE = 1;

    private double x;
    private double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        if (this.x > OUTER_CIRCLE || this.y > OUTER_CIRCLE) {
            return 0;
        }
        if (this.x > MIDDLE_CIRCLE || this.y > MIDDLE_CIRCLE) {
            return 1;
        }
        if (this.x > INNER_CIRCLE || this.y > INNER_CIRCLE) {
            return 5;
        }
        return 10;
    }

}
