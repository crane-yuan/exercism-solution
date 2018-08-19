class RaindropConverter {

    String convert(int number) {
        boolean flag = false;
        StringBuilder result = new StringBuilder();

        if (number % 3 == 0) {
            result.append("Pling");
            flag = true;
        }

        if (number % 5 == 0) {
            result.append("Plang");
            flag = true;
        }

        if (number % 7 == 0) {
            result.append("Plong");
            flag = true;
        }
        return flag ? result.toString() : String.valueOf(number);
    }

}
