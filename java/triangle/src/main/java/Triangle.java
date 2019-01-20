import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Triangle {
    private final double side1;
    private final double side2;
    private final double side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (!isTriangle()) {
            throw new TriangleException();
        }
    }

    boolean isEquilateral() {
        return allSidesAreEqual();
    }

    boolean isIsosceles() {
        return twoSidesAreEqual();
    }

    boolean isScalene() {
        return noSidesAreEqual();
    }

    private boolean isTriangle() {
        return respectsInequality() && hasNoNullSides();
    }

    private Stream<Double> sides() {
        return Stream.of(side1, side2, side3);
    }

    private boolean hasNoNullSides() {
        return sides().noneMatch(x -> x <= 0.0);
    }

    private boolean respectsInequality() {
        List<Double> sortedSides = sides().sorted()
                                          .collect(Collectors.toList());
        return sortedSides.get(0) + sortedSides.get(1) >= sortedSides.get(2);
    }

    private int uniqueSideValues() {
        return sides().collect(Collectors.toSet())
                      .size();
    }

    private boolean allSidesAreEqual() {
        return uniqueSideValues() == 1;
    }

    private boolean twoSidesAreEqual() {
        return uniqueSideValues() <= 2;
    }

    private boolean noSidesAreEqual() {
        return uniqueSideValues() == 3;
    }
}
