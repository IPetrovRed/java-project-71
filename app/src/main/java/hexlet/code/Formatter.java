package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(
            List<Map<String, Object>> differences, String formatType) throws IOException {
        return switch (formatType) {
            case "stylish" -> StylishFormatter.stylishFormatter(differences);
            case "plain" -> PlainFormatter.plainFormatter(differences);
            case "json" -> JsonFormatter.json(differences);
            default -> throw new RuntimeException("Format" + formatType + "incorrect format!");
        };
    }
}
