import java.util.Arrays;
import java.util.List;

class Acronym {

    private String phrase;
    private String acronym;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        if (this.acronym == null) {
            List<String> list = Arrays.asList(this.phrase.split("[\\s-]+"));

            StringBuilder sb = new StringBuilder();

            list.stream()
                .map(s -> s.substring(0, 1))
                .map(String::toUpperCase)
                .forEach(s -> sb.append(s));
            this.acronym = sb.toString();
        }

        return this.acronym;
    }

}
