class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (!isTriangle(side1, side2, side3)) {
            throw new TriangleException();
        }
    }

    boolean isEquilateral() {
        if (side1 == side2 && side2 == side3) {
            return true;
        }
        return false;
    }

    boolean isIsosceles() {
        if (side1 == side2 || side1 == side3 || side2 == side3) {
            return true;
        }
        return false;
    }

    boolean isScalene() {
        return !isIsosceles();
    }

    private boolean isTriangle(double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return false;
        }
        if ((side1 + side2 >= side3) && (side1 + side3 >= side2) && (side2 + side3 >= side1)) {
            return true;
        }
        return false;
    }

}
