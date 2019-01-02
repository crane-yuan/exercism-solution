import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BracketChecker {

    private String originalStr;

    public BracketChecker(String originalStr) {
        this.originalStr = originalStr;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        LinkedList<String> stack = new LinkedList<>();

        Set<String> leftBracketSet = new HashSet<>(Arrays.asList("(", "[", "{"));
        Map<String, String> bracketMap = new HashMap<>();
        bracketMap.put(")", "(");
        bracketMap.put("]", "[");
        bracketMap.put("}", "{");

        String[] array = this.originalStr.split("");
        for (String str : array) {
            if (leftBracketSet.contains(str)) {
                stack.push(str);
            } else {
                String bracket = bracketMap.get(str);
                if (bracket != null) {
                    if (stack.isEmpty() || !bracket.equals(stack.peek())) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
