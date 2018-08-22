import java.util.HashMap;
import java.util.Map;

/**
 * @author craneyuan
 */
public class FoodChain {

    private static final String SONG =
            "I know an old lady who swallowed a fly.\n" + "I don't know why she swallowed the fly. Perhaps she'll die.\n" + "\n"
                    + "I know an old lady who swallowed a spider.\n" + "It wriggled and jiggled and tickled inside her.\n"
                    + "She swallowed the spider to catch the fly.\n" + "I don't know why she swallowed the fly. Perhaps she'll die.\n"
                    + "\n" + "I know an old lady who swallowed a bird.\n" + "How absurd to swallow a bird!\n"
                    + "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n"
                    + "She swallowed the spider to catch the fly.\n" + "I don't know why she swallowed the fly. Perhaps she'll die.\n"
                    + "\n" + "I know an old lady who swallowed a cat.\n" + "Imagine that, to swallow a cat!\n"
                    + "She swallowed the cat to catch the bird.\n"
                    + "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n"
                    + "She swallowed the spider to catch the fly.\n" + "I don't know why she swallowed the fly. Perhaps she'll die.\n"
                    + "\n" + "I know an old lady who swallowed a dog.\n" + "What a hog, to swallow a dog!\n"
                    + "She swallowed the dog to catch the cat.\n" + "She swallowed the cat to catch the bird.\n"
                    + "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n"
                    + "She swallowed the spider to catch the fly.\n" + "I don't know why she swallowed the fly. Perhaps she'll die.\n"
                    + "\n" + "I know an old lady who swallowed a goat.\n" + "Just opened her throat and swallowed a goat!\n"
                    + "She swallowed the goat to catch the dog.\n" + "She swallowed the dog to catch the cat.\n"
                    + "She swallowed the cat to catch the bird.\n"
                    + "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n"
                    + "She swallowed the spider to catch the fly.\n" + "I don't know why she swallowed the fly. Perhaps she'll die.\n"
                    + "\n" + "I know an old lady who swallowed a cow.\n" + "I don't know how she swallowed a cow!\n"
                    + "She swallowed the cow to catch the goat.\n" + "She swallowed the goat to catch the dog.\n"
                    + "She swallowed the dog to catch the cat.\n" + "She swallowed the cat to catch the bird.\n"
                    + "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n"
                    + "She swallowed the spider to catch the fly.\n" + "I don't know why she swallowed the fly. Perhaps she'll die.\n"
                    + "\n" + "I know an old lady who swallowed a horse.\n" + "She's dead, of course!";
    private static final Map<Integer, String> SONG_MAP = new HashMap<>();

    static {
        String[] array = SONG.split("\n\n");

        for (int i = 0; i < array.length; i++) {
            SONG_MAP.put(i + 1, array[i]);
        }
    }

    String verse(int verseNumber) {
        return SONG_MAP.get(verseNumber);
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder result = new StringBuilder();
        for (int i = startVerse; i < endVerse; i++) {
            result.append(SONG_MAP.get(i))
                  .append("\n\n");
        }
        result.append(SONG_MAP.get(endVerse));

        return result.toString();
    }

}
