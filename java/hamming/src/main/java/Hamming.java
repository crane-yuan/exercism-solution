class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        char[] left = this.leftStrand.toCharArray();
        char[] right = this.rightStrand.toCharArray();

        for (int i = 0; i < left.length; i++) {
            if (left[i] != right[i]) {
                distance++;
            }
        }

        return distance;
    }

}
