import java.util.HashMap;
import java.util.Map;

public class House {

    private static final String SONG =
            "This is the house that Jack built.\n" + "This is the malt " + "that lay in the house that Jack built.\n" + "This is the rat "
                    + "that ate the malt " + "that lay in the house that Jack built.\n" + "This is the cat " + "that killed the rat "
                    + "that ate the malt " + "that lay in the house that Jack built.\n" + "This is the dog " + "that worried the cat "
                    + "that killed the rat " + "that ate the malt " + "that lay in the house that Jack built.\n"
                    + "This is the cow with the crumpled horn " + "that tossed the dog " + "that worried the cat " + "that killed the rat "
                    + "that ate the malt " + "that lay in the house that Jack built.\n" + "This is the maiden all forlorn "
                    + "that milked the cow with the crumpled horn " + "that tossed the dog " + "that worried the cat "
                    + "that killed the rat " + "that ate the malt " + "that lay in the house that Jack built.\n"
                    + "This is the man all tattered and torn " + "that kissed the maiden all forlorn "
                    + "that milked the cow with the crumpled horn " + "that tossed the dog " + "that worried the cat "
                    + "that killed the rat " + "that ate the malt " + "that lay in the house that Jack built.\n"
                    + "This is the priest all shaven and shorn " + "that married the man all tattered and torn "
                    + "that kissed the maiden all forlorn " + "that milked the cow with the crumpled horn " + "that tossed the dog "
                    + "that worried the cat " + "that killed the rat " + "that ate the malt " + "that lay in the house that Jack built.\n"
                    + "This is the rooster that crowed in the morn " + "that woke the priest all shaven and shorn "
                    + "that married the man all tattered and torn " + "that kissed the maiden all forlorn "
                    + "that milked the cow with the crumpled horn " + "that tossed the dog " + "that worried the cat "
                    + "that killed the rat " + "that ate the malt " + "that lay in the house that Jack built.\n"
                    + "This is the farmer sowing his corn " + "that kept the rooster that crowed in the morn "
                    + "that woke the priest all shaven and shorn " + "that married the man all tattered and torn "
                    + "that kissed the maiden all forlorn " + "that milked the cow with the crumpled horn " + "that tossed the dog "
                    + "that worried the cat " + "that killed the rat " + "that ate the malt " + "that lay in the house that Jack built.\n"
                    + "This is the horse and the hound and the horn " + "that belonged to the farmer sowing his corn "
                    + "that kept the rooster that crowed in the morn " + "that woke the priest all shaven and shorn "
                    + "that married the man all tattered and torn " + "that kissed the maiden all forlorn "
                    + "that milked the cow with the crumpled horn " + "that tossed the dog " + "that worried the cat "
                    + "that killed the rat " + "that ate the malt " + "that lay in the house that Jack built.";

    private static final Map<Integer, String> SONG_MAP = new HashMap<>();

    static {
        String[] array = SONG.split("\n");

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
                  .append("\n");
        }
        result.append(SONG_MAP.get(endVerse));

        return result.toString();
    }

    String sing() {
        return SONG;
    }
}
