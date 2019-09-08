public class ComplexNumber {

    private double real;
    private double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public ComplexNumber times(ComplexNumber complexNumber) {
        return new ComplexNumber(this.real * complexNumber.getReal() - this.getImag() * complexNumber.getImag(),
                                 this.real * complexNumber.getImag() + this.imag * complexNumber.getReal());
    }

    public ComplexNumber add(ComplexNumber complexNumber) {
        return new ComplexNumber(this.real + complexNumber.getReal(), this.imag + complexNumber.getImag());
    }

    public ComplexNumber minus(ComplexNumber complexNumber) {
        return new ComplexNumber(this.real - complexNumber.getReal(), this.imag - complexNumber.getImag());
    }

    public ComplexNumber div(ComplexNumber complexNumber) {
        return new ComplexNumber(
                (this.real * complexNumber.getReal() + this.getImag() * complexNumber.getImag()) / (Math.pow(complexNumber.getReal(), 2)
                        + Math.pow(complexNumber.getImag(), 2)),
                (this.imag * complexNumber.getReal() - this.real * complexNumber.getImag()) / (Math.pow(complexNumber.getReal(), 2)
                        + Math.pow(complexNumber.getImag(), 2)));
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imag);
    }

    public ComplexNumber exponentialOf() {
        return new ComplexNumber(Math.exp(this.real) * Math.cos(this.imag), Math.exp(this.real) * Math.sin(this.imag));
    }

}
