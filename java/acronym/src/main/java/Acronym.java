import java.util.Arrays;
import java.util.List;

class Acronym {

    private String phrase;

    public Acronym(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        List<String> list = Arrays.asList(this.phrase.split("[\\s-]+"));

        StringBuilder sb = new StringBuilder();

        list.stream()
            .map(s -> s.substring(0, 1))
            .map(String::toUpperCase)
            .forEach(s -> sb.append(s));
        return sb.toString();
    }

}
