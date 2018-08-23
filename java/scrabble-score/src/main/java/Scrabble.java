class Scrabble {

    private String word;
    private static final String[] SCORE_ARRAY =
            {"", "A, E, I, O, U, L, N, R, S, T", "D, G", "B, C, M, P", "F, H, V, W, Y", "K", "", "", "J, X", "", "Q, Z"};
    /*
     A, E, I, O, U, L, N, R, S, T       1
     D, G                               2
     B, C, M, P                         3
     F, H, V, W, Y                      4
     K                                  5
     J, X                               8
     Q, Z                               10
     */

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        int sum = 0;
        String[] array = this.word.toUpperCase()
                                  .split("");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < SCORE_ARRAY.length; j++) {
                if (SCORE_ARRAY[j].contains(array[i])) {
                    sum += j;
                    break;
                }
            }
        }

        return sum;
    }

}
