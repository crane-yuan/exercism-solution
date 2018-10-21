import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BracketChecker {

    private String originalStr;

    public BracketChecker(String originalStr) {
        this.originalStr = originalStr;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<String> stack = new Stack<>();
        Set<String> leftBracketSet = new HashSet<>(Arrays.asList("(", "[", "{"));
        Map<String, String> bracketMap = new HashMap<String, String>() {{
            put(")", "(");
            put("]", "[");
            put("}", "{");
        }};

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
