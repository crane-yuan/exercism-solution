import java.math.BigInteger;
import java.util.function.BiFunction;

class Rational {

    private int numerator;
    private int denominator;

    Rational(int numerator, int denominator) {
        int r = gcd(numerator, denominator);
        this.numerator = numerator / r;
        this.denominator = denominator / r;
        if (this.denominator < 0) {
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
        }
    }

    int getNumerator() {
        return this.numerator;
    }

    int getDenominator() {
        return this.denominator;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass()
                                .isAssignableFrom(obj.getClass())) {
            return false;
        }

        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();

        return result;
    }

    public Rational add(Rational rational) {
        return apply(this, rational, (a, b) -> a + b);
    }

    public Rational subtract(Rational rational) {
        return apply(this, rational, (a, b) -> a - b);
    }

    public Rational multiply(Rational rational) {
        Rational a = this;
        Rational b = rational;
        int numerator = a.getNumerator() * b.getNumerator();
        int denominator = a.getDenominator() * b.getDenominator();
        return new Rational(numerator, denominator);
    }

    public Rational divide(Rational rational) {
        Rational a = this;
        Rational b = rational;
        int numerator = a.getNumerator() * b.getDenominator();
        int denominator = a.getDenominator() * b.getNumerator();
        return new Rational(numerator, denominator);
    }

    public Rational abs() {
        int numerator = Math.abs(this.numerator);
        int denominator = Math.abs(this.denominator);
        return new Rational(numerator, denominator);
    }

    public Rational pow(int i) {
        int numerator = (int) Math.pow(this.numerator, i);
        int denominator = (int) Math.pow(this.denominator, i);
        return new Rational(numerator, denominator);
    }

    public double exp(double x) {
        return Math.pow(Math.pow(x, 1.0 / this.denominator), this.numerator);
    }

    private Rational apply(Rational a, Rational b, BiFunction<Integer, Integer, Integer> function) {
        int numerator = function.apply(a.getNumerator() * b.getDenominator(), a.getDenominator() * b.getNumerator());
        int denominator = a.getDenominator() * b.getDenominator();

        return new Rational(numerator, denominator);
    }

    private int gcd(int a, int b) {
        return BigInteger.valueOf(a)
                         .gcd(BigInteger.valueOf(b))
                         .intValue();
    }
}
