import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    public String translate(String phrase) {
        List<String> list = Arrays.asList(phrase.split("[\\s]+"));

        String result = list.stream()
                            .map(this::translateForWord)
                            .collect(Collectors.joining(" "));

        return result;
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
            int y_index = word.indexOf(y);
            if (y_index == 1 || y_index == 2) {
                return word.substring(y_index, size) + word.substring(0, y_index) + ay;

            }

            int qu_index = word.indexOf(qu);
            if (qu_index != -1) {
                if (qu_index == 0) {
                    return word.substring(qu_index + 2, size) + qu + ay;
                }
                return word.substring(qu_index + 2, size) + capital + qu + ay;
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
