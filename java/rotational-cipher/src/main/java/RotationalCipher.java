class RotationalCipher {

    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char letter = data.charAt(i);
            if (Character.isLowerCase(letter)) {
                result.append((char) ((letter - 'a' + shiftKey) % 26 + 'a'));
            } else if (Character.isUpperCase(letter)) {
                result.append((char) ((letter - 'A' + shiftKey) % 26 + 'A'));

            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }

}
