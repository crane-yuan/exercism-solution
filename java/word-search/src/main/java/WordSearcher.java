import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordSearcher {

    private static final int[][] DIRECTION = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    Map<String, Optional<WordLocation>> search(Set<String> searchWords, char[][] square) {
        return searchWords.stream()
                          .collect(Collectors.toMap(Function.identity(), searchWord -> search(searchWord, square)));
    }

    Optional<WordLocation> search(String searchWord, char[][] square) {
        int row = square.length;
        if (row == 0) {
            return Optional.empty();
        }
        int col = square[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int direction = 0; direction < DIRECTION.length; direction++) {
                    if (check(searchWord, square, r, c, direction)) {
                        return Optional.of(new WordLocation(new Pair(c + 1, r + 1),
                                                            new Pair(c + (searchWord.length() - 1) * DIRECTION[direction][1] + 1,
                                                                     r + (searchWord.length() - 1) * DIRECTION[direction][0] + 1)));
                    }
                }
            }
        }
        return Optional.empty();
    }

    boolean check(String searchWord, char[][] square, int r, int c, int direction) {
        int row = square.length;
        int col = square[0].length;
        for (int i = 0; i < searchWord.length(); i++) {
            int nextR = r + i * DIRECTION[direction][0];
            int nextC = c + i * DIRECTION[direction][1];

            if (!(nextR >= 0 && nextR < row && nextC >= 0 && nextC < col && square[nextR][nextC] == searchWord.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
