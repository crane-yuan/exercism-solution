import java.util.Objects;

class MicroBlog {
    private static final int LEN_LIMIT = 5;

    public String truncate(String input) {
        if (Objects.isNull(input)) {
            return null;
        }
        int len = input.codePointCount(0, input.length());
        if (len > LEN_LIMIT) {
            return input.substring(0, input.offsetByCodePoints(0, LEN_LIMIT));
        }
        return input;
    }

}
