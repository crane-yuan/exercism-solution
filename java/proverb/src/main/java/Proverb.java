class Proverb {

    private String[] words;
    private static final String WORD_PATTERN = "For want of a %s the %s was lost.\n";
    private static final String END_PATTERN = "And all for the want of a %s.";

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length - 1; i++) {
            result.append(String.format(WORD_PATTERN, words[i], words[i + 1]));
        }

        if (words.length > 0) {
            result.append(String.format(END_PATTERN, words[0]));
        }

        return result.toString();
    }

}
