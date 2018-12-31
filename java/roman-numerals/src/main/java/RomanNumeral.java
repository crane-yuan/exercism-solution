public class RomanNumeral {

    private Integer original;
    private String romanValue;

    public RomanNumeral(Integer original) {
        if (original < 0) {
            throw new IllegalArgumentException("roman number can not be negative number");
        }
        this.original = original;
    }

    public String getRomanNumeral() {
        if (romanValue != null) {
            return this.romanValue;
        }

        StringBuilder result = new StringBuilder();
        Numeral[] numerals = Numeral.values();
        int num = this.original;
        for (int i = numerals.length - 1; i >= 0; i--) {
            while (num >= numerals[i].weight) {
                result.append(numerals[i]);
                num -= numerals[i].weight;
            }
        }
        return result.toString();
    }

    enum Numeral {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);
        int weight;

        Numeral(int weight) {
            this.weight = weight;
        }
    }

}
