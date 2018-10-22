public class RunLengthEncoding {

    public String encode(String str) {
        String[] array = str.split("");
        StringBuilder result = new StringBuilder();
        String prev = "";
        int count = -1;
        for (int i = 0; i <= array.length; i++) {
            if (i < array.length && array[i].equals(prev)) {
                count++;
            } else {
                if (count > 0) {
                    if (count != 1) {
                        result.append(count);
                    }
                    result.append(prev);
                }

                if (i < array.length) {
                    prev = array[i];
                    count = 1;
                }
            }
        }
        return result.toString();
    }

    public String decode(String str) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < str.length()) {
            int endIndex = index;
            while (endIndex < str.length() && Character.isDigit(str.charAt(endIndex))) {
                endIndex++;
            }

            int count;
            if (endIndex == index) {
                count = 1;
            } else {
                count = Integer.parseInt(str.substring(index, endIndex));
            }

            char letter = str.charAt(endIndex);
            for (int i = 0; i < count; i++) {
                result.append(letter);
            }

            index = endIndex + 1;
        }
        return result.toString();

    }
}
