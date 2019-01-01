class Markdown {

    String parse(String markdown) {

        String[] lines = markdown.split("\n");

        StringBuilder result = new StringBuilder();

        boolean activeList = false;

        for (String line : lines) {
            String parsedLine;

            if (isListItem(line)) {
                if (!activeList) {
                    result.append("<ul>");
                    activeList = true;
                }
                parsedLine = parseListItem(line);
            } else {
                if (activeList) {
                    result.append("</ul>");
                    activeList = false;
                }
                if (isHeader(line)) {
                    parsedLine = parseHeader(line);
                } else {
                    parsedLine = parseParagraph(line);
                }

            }
            result.append(parsedLine);
        }

        if (activeList) {
            result.append("</ul>");
        }

        return result.toString();
    }

    private boolean isListItem(String line) {
        return line.startsWith("*");
    }

    private boolean isHeader(String line) {
        return line.startsWith("#");
    }

    private String parseHeader(String markdown) {
        int count = 0;

        while (markdown.charAt(count) == '#') {
            count++;
        }

        if (count == 0) {
            return null;
        }

        return String.format("<h%d>%s</h%d>", count, markdown.substring(count + 1), count);
    }

    private String parseParagraph(String line) {
        return "<p>" + parseSomeSymbols(line) + "</p>";
    }

    private String parseListItem(String line) {
        return "<li>" + parseSomeSymbols(line.substring(2)) + "</li>";
    }

    private String parseSomeSymbols(String line) {
        return line.replaceAll("__(.+)__", "<strong>$1</strong>")
                   .replaceAll("_(.+)_", "<em>$1</em>");
    }
}