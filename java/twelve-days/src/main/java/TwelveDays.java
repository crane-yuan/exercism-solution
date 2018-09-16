import java.util.HashMap;
import java.util.Map;

class TwelveDays {

    private static final String PHRASE_01 = "and a Partridge in a Pear Tree.\n";
    private static final String PHRASE_02 = "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";

    private static final String SONG = "On the first day of Christmas my true love gave to me, a Partridge in a Pear Tree.\n" + "\n"
            + "On the second day of Christmas my true love gave to me, two Turtle Doves, " + PHRASE_01 + "\n"
            + "On the third day of Christmas my true love gave to me, three French Hens, two Turtle Doves, " + PHRASE_01 + "\n"
            + "On the fourth day of Christmas my true love gave to me, four Calling Birds, three French Hens, "
            + "two Turtle Doves, and a Partridge in a Pear Tree.\n" + "\n"
            + "On the fifth day of Christmas my true love gave to me, five Gold Rings, four Calling Birds, " + PHRASE_02 + "\n"
            + "On the sixth day of Christmas my true love gave to me, six Geese-a-Laying, five Gold Rings, "
            + "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" + "\n"
            + "On the seventh day of Christmas my true love gave to me, seven Swans-a-Swimming, "
            + "six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " + PHRASE_01 + "\n"
            + "On the eighth day of Christmas my true love gave to me, eight Maids-a-Milking, "
            + "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " + PHRASE_02 + "\n"
            + "On the ninth day of Christmas my true love gave to me, nine Ladies Dancing, eight Maids-a-Milking,"
            + " seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " + PHRASE_02 + "\n"
            + "On the tenth day of Christmas my true love gave to me, ten Lords-a-Leaping, nine Ladies Dancing,"
            + " eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, "
            + "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" + "\n"
            + "On the eleventh day of Christmas my true love gave to me, eleven Pipers Piping, "
            + "ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, "
            + "six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " + PHRASE_01 + "\n"
            + "On the twelfth day of Christmas my true love gave to me, twelve Drummers Drumming, "
            + "eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, "
            + "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " + PHRASE_02;

    private static final Map<Integer, String> SONG_MAP = new HashMap<>();

    static {
        String[] array = SONG.split("\n\n");

        for (int i = 0; i < array.length - 1; i++) {
            SONG_MAP.put(i + 1, array[i] + "\n");
        }
        SONG_MAP.put(array.length, array[array.length - 1]);
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

    public String sing() {
        return SONG;
    }

}
