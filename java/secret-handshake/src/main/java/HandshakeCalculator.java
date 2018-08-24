import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HandshakeCalculator {

    private static final Map<Integer, Signal> map = new HashMap<>();

    static {
        map.put(1, Signal.WINK);
        map.put(10, Signal.DOUBLE_BLINK);
        map.put(100, Signal.CLOSE_YOUR_EYES);
        map.put(1000, Signal.JUMP);
    }

    List<Signal> calculateHandshake(int number) {
        char[] binary = Integer.toBinaryString(number)
                               .toCharArray();

        List<Signal> result = new ArrayList<>();
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == '1') {
                int size = (int) Math.pow(10, binary.length - i - 1);
                Signal signal = map.get(size);
                if (signal != null) {
                    result.add(signal);
                }
                if (size == 10000) {
                    Collections.reverse(result);
                }
            }
        }
        return result;
    }

}
