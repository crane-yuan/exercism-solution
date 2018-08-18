class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        char[] array = String.valueOf(numberToCheck)
                             .toCharArray();

        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += Math.pow(array[i] - '0', array.length);
        }

        return numberToCheck == sum ? true : false;
    }

}
