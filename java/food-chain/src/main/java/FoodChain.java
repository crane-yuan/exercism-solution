import java.util.HashMap;
import java.util.Map;

/**
 * @author craneyuan
 */
public class FoodChain {

    private static final String PHRASE_01 = "I don't know why she swallowed the fly. Perhaps she'll die.\n";
    private static final String PHRASE_02 = "She swallowed the spider to catch the fly.\n";
    private static final String PHRASE_03 =
            "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n";
    private static final String PHRASE_04 = "She swallowed the cat to catch the bird.\n";
    private static final String PHRASE_05 = "She swallowed the dog to catch the cat.\n";

    private static final String SONG =
            "I know an old lady who swallowed a fly.\n" + PHRASE_01 + "\n" + "I know an old lady who swallowed a spider.\n"
                    + "It wriggled and jiggled and tickled inside her.\n" + PHRASE_02 + PHRASE_01 + "\n"
                    + "I know an old lady who swallowed a bird.\n" + "How absurd to swallow a bird!\n" + PHRASE_03 + PHRASE_02 + PHRASE_01
                    + "\n" + "I know an old lady who swallowed a cat.\n" + "Imagine that, to swallow a cat!\n" + PHRASE_04 + PHRASE_03
                    + PHRASE_02 + PHRASE_01 + "\n" + "I know an old lady who swallowed a dog.\n" + "What a hog, to swallow a dog!\n"
                    + PHRASE_05 + PHRASE_04 + PHRASE_03 + PHRASE_02 + PHRASE_01 + "\n" + "I know an old lady who swallowed a goat.\n"
                    + "Just opened her throat and swallowed a goat!\n" + "She swallowed the goat to catch the dog.\n" + PHRASE_05
                    + PHRASE_04 + PHRASE_03 + PHRASE_02 + PHRASE_01 + "\n" + "I know an old lady who swallowed a cow.\n"
                    + "I don't know how she swallowed a cow!\n" + "She swallowed the cow to catch the goat.\n"
                    + "She swallowed the goat to catch the dog.\n" + PHRASE_05 + PHRASE_04 + PHRASE_03 + PHRASE_02 + PHRASE_01 + "\n"
                    + "I know an old lady who swallowed a horse.\n" + "She's dead, of course!";
    private static final Map<Integer, String> SONG_MAP = new HashMap<>();

    static {
        String[] array = SONG.split("\n\n");

        for (int i = 0; i < array.length; i++) {
            SONG_MAP.put(i + 1, array[i]);
        }
    }

    public String verse(int verseNumber) {
        return SONG_MAP.get(verseNumber);
    }

    public String verses(int startVerse, int endVerse) {
        StringBuilder result = new StringBuilder();
        for (int i = startVerse; i < endVerse; i++) {
            result.append(SONG_MAP.get(i))
                  .append("\n\n");
        }
        result.append(SONG_MAP.get(endVerse));

        return result.toString();
    }

}
