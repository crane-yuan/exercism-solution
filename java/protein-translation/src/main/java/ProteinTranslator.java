import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    private static final Map<String, String> map = new HashMap<>();
    private static final String stop = "UAA, UAG, UGA";

    static {
        map.put("AUG", "Methionine");
        map.put("UUU", "Phenylalanine");
        map.put("UUC", "Phenylalanine");
        map.put("UUA", "Leucine");
        map.put("UUG", "Leucine");
        map.put("UCU", "Serine");
        map.put("UCC", "Serine");
        map.put("UCA", "Serine");
        map.put("UCG", "Serine");
        map.put("UAU", "Tyrosine");
        map.put("UAC", "Tyrosine");
        map.put("UGU", "Cysteine");
        map.put("UGC", "Cysteine");
        map.put("UGG", "Tryptophan");
    }

    List<String> translate(String rnaSequence) {

        List<String> rnaList = getParts(rnaSequence, 3);

        List<String> result = new ArrayList<>();

        for (String rna : rnaList) {
            if (stop.contains(rna)) {
                return result;
            }
            String temp = map.get(rna);
            if (temp != null && !result.contains(temp)) {
                result.add(temp);
            }
        }
        return result;
    }

    private static List<String> getParts(String string, int partitionSize) {
        List<String> parts = new ArrayList<>();
        int len = string.length();
        for (int i = 0; i < len; i += partitionSize) {
            parts.add(string.substring(i, Math.min(len, i + partitionSize)));
        }
        return parts;
    }
}