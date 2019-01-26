import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class WordProblemSolver {

    public int solve(String problem) {
        // parse operator
        Queue<Operator> opQueue = new LinkedList<>();

        for (String word : problem.split(" ")) {
            Operator op = null;
            try {
                op = Operator.valueOf(word.toUpperCase());
            } catch (IllegalArgumentException e) {
                // ignore
            }
            if (op != null) {
                opQueue.add(op);
            }
        }

        if (opQueue.isEmpty()) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

        // parse number
        String[] tempNums = problem.replaceAll("[^0-9 -]", "").split(" ");

        List<String> nums = Arrays.stream(tempNums).filter(s -> s.length() > 0).collect(Collectors.toList());

        if (nums.size() < 2) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
        BigDecimal a = new BigDecimal(nums.get(0));
        BigDecimal b = new BigDecimal(nums.get(1));
        Operator curOp = ((LinkedList<Operator>) opQueue).pop();
        BigDecimal result = curOp.operate.apply(a, b);
        for (int i = 2; i < nums.size(); i++) {
            BigDecimal c = new BigDecimal(nums.get(i));
            curOp = ((LinkedList<Operator>) opQueue).pop();
            result = curOp.operate.apply(result, c);
        }
        return result.intValue();
    }

    private enum Operator {
        PLUS(BigDecimal::add),
        MINUS(BigDecimal::subtract),
        MULTIPLIED(BigDecimal::multiply),
        DIVIDED(BigDecimal::divideToIntegralValue),
        POWER((a, b) -> a.pow(b.intValue()));

        Operator(BiFunction<BigDecimal, BigDecimal, BigDecimal> operate) {
            this.operate = operate;
        }

        BiFunction<BigDecimal, BigDecimal, BigDecimal> operate;
    }
}
