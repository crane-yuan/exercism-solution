import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    public String translate(String phrase) {
        List<String> list = Arrays.asList(phrase.split("[\\s]+"));

        return list.stream()
                   .map(this::translateForWord)
                   .collect(Collectors.joining(" "));
    }

    private String translateForWord(String word) {
        String vowel = "aeiou";
        String ay = "ay";
        String qu = "qu";
        String y = "y";
        String xr = "xr";
        String yt = "yt";
        String ch = "ch";
        String th = "th";
        String thr = "thr";
        String sch = "sch";

        String capital = word.substring(0, 1);
        int size = word.length();

        if (vowel.contains(capital.toLowerCase()) || word.startsWith(xr) || word.startsWith(yt)) {
            return word + ay;
        } else {
            int yIndex = word.indexOf(y);
            if (yIndex == 1 || yIndex == 2) {
                return word.substring(yIndex, size) + word.substring(0, yIndex) + ay;

            }

            int quIndex = word.indexOf(qu);
            if (quIndex != -1) {
                if (quIndex == 0) {
                    return word.substring(quIndex + 2, size) + qu + ay;
                }
                return word.substring(quIndex + 2, size) + capital + qu + ay;
            }

            if (word.startsWith(ch)) {
                return word.substring(2, size) + ch + ay;
            }

            if (word.startsWith(thr)) {
                return word.substring(3, size) + thr + ay;
            }

            if (word.startsWith(th)) {
                return word.substring(2, size) + th + ay;
            }

            if (word.startsWith(sch)) {
                return word.substring(3, size) + sch + ay;
            }

            return word.substring(1, size) + capital + ay;

        }
    }
}
