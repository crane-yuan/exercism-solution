public class Robot {

    private Orientation orientation;
    private GridPosition gridPosition;

    public Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void turnRight() {
        switch (orientation) {
            case NORTH:
                this.orientation = Orientation.EAST;
                break;
            case EAST:
                this.orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                this.orientation = Orientation.WEST;
                break;
            case WEST:
                this.orientation = Orientation.NORTH;
                break;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case NORTH:
                this.orientation = Orientation.WEST;
                break;
            case EAST:
                this.orientation = Orientation.NORTH;
                break;
            case SOUTH:
                this.orientation = Orientation.EAST;
                break;
            case WEST:
                this.orientation = Orientation.SOUTH;
                break;
        }
    }

    public void advance() {
        switch (orientation) {
            case NORTH:
                this.gridPosition = new GridPosition(this.gridPosition.x, this.gridPosition.y + 1);
                break;
            case EAST:
                this.gridPosition = new GridPosition(this.gridPosition.x + 1, this.gridPosition.y);
                break;
            case SOUTH:
                this.gridPosition = new GridPosition(this.gridPosition.x, this.gridPosition.y - 1);
                break;
            case WEST:
                this.gridPosition = new GridPosition(this.gridPosition.x - 1, this.gridPosition.y);
                break;
        }
    }

    public void simulate(String instructions) {
        char[] array = instructions.toCharArray();
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 'R':
                    turnRight();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'A':
                    advance();
                    break;
                default:
                    throw new IllegalArgumentException("Wrong instructions.");
            }
        }
    }
}
