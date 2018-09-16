import java.util.HashMap;
import java.util.Map;

public class House {

    private static final String PHRASE_01 = "that lay in the house that Jack built.\n";
    private static final String PHRASE_02 = "that killed the rat ";
    private static final String PHRASE_03 = "that worried the cat ";
    private static final String PHRASE_04 = "that ate the malt ";
    private static final String PHRASE_05 = "that milked the cow with the crumpled horn ";
    private static final String PHRASE_06 = "that kissed the maiden all forlorn ";
    private static final String PHRASE_07 = "that married the man all tattered and torn ";
    private static final String PHRASE_08 = "that woke the priest all shaven and shorn ";
    private static final String PHRASE_09 = "that tossed the dog ";

    private static final String SONG =
            "This is the house that Jack built.\n" + "This is the malt " + PHRASE_01 + "This is the rat " + PHRASE_04 + PHRASE_01
                    + "This is the cat " + PHRASE_02 + PHRASE_04 + PHRASE_01 + "This is the dog " + PHRASE_03 + PHRASE_02 + PHRASE_04
                    + PHRASE_01 + "This is the cow with the crumpled horn " + PHRASE_09 + PHRASE_03 + PHRASE_02 + PHRASE_04 + PHRASE_01
                    + "This is the maiden all forlorn " + PHRASE_05 + PHRASE_09 + PHRASE_03 + PHRASE_02 + PHRASE_04 + PHRASE_01
                    + "This is the man all tattered and torn " + PHRASE_06 + PHRASE_05 + PHRASE_09 + PHRASE_03 + PHRASE_02 + PHRASE_04
                    + PHRASE_01 + "This is the priest all shaven and shorn " + PHRASE_07 + PHRASE_06 + PHRASE_05 + PHRASE_09 + PHRASE_03
                    + PHRASE_02 + PHRASE_04 + PHRASE_01 + "This is the rooster that crowed in the morn " + PHRASE_08 + PHRASE_07 + PHRASE_06
                    + PHRASE_05 + PHRASE_09 + PHRASE_03 + PHRASE_02 + PHRASE_04 + PHRASE_01 + "This is the farmer sowing his corn "
                    + "that kept the rooster that crowed in the morn " + PHRASE_08 + PHRASE_07 + PHRASE_06 + PHRASE_05 + PHRASE_09
                    + PHRASE_03 + PHRASE_02 + PHRASE_04 + PHRASE_01 + "This is the horse and the hound and the horn "
                    + "that belonged to the farmer sowing his corn " + "that kept the rooster that crowed in the morn " + PHRASE_08
                    + PHRASE_07 + PHRASE_06 + PHRASE_05 + PHRASE_09 + PHRASE_03 + PHRASE_02 + PHRASE_04
                    + "that lay in the house that Jack built.";

    private static final Map<Integer, String> SONG_MAP = new HashMap<>();

    static {
        String[] array = SONG.split("\n");

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
                  .append("\n");
        }
        result.append(SONG_MAP.get(endVerse));

        return result.toString();
    }

    String sing() {
        return SONG;
    }
}
