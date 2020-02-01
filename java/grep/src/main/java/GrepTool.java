import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GrepTool {

    /**
     * Options
     * -n Print the line numbers of each matching line.
     * -l Print only the names of files that contain at least one matching line.
     * -i Match line using a case-insensitive comparison.
     * -v Invert the program -- collect all lines that fail to match the pattern.
     * -x Only match entire lines, instead of lines that contain a match.
     */
    public String grep(String pattern, List<String> options, List<String> fileNames) {
        StringBuilder resp = new StringBuilder();

        for (String filename : fileNames) {
            Path file = Paths.get(filename);
            List<String> lines = null;
            try {
                lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }

            boolean firstFound = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (matched(line, pattern, options)) {
                    if (options.contains("-l")) {
                        if (!firstFound) {
                            if (resp.length() != 0) {
                                resp.append("\n");
                            }
                            resp.append(filename);
                        }
                    } else {
                        if (resp.length() != 0) {
                            resp.append("\n");
                        }
                        if (fileNames.size() > 1) {
                            resp.append(filename);
                            resp.append(":");
                        }
                        if (options.contains("-n")) {
                            resp.append(i + 1);
                            resp.append(":");
                        }
                        resp.append(line);
                    }
                    firstFound = true;
                }
            }

        }

        return resp.toString();
    }

    private boolean matched(String line, String pattern, List<String> options) {
        boolean match = !options.contains("-x") || pattern.length() == line.length();

        if (match) {
            if (options.contains("-i")) {
                pattern = pattern.toLowerCase();
                line = line.toLowerCase();
            }
            match = line.contains(pattern);
        }
        return options.contains("-v") != match;
    }
}
