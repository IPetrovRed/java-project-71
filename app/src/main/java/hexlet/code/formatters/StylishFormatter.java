package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String stylishFormatter(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> diff : differences) {
            switch (diff.get("type").toString()) {
                case "removed":
                    result.append("  - ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("oldValue"))
                            .append("\n");
                    break;
                case "added":
                    result.append("  + ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("newValue"))
                            .append("\n");
                    break;
                case "equals":
                    result.append("    ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("oldValue"))
                            .append("\n");
                    break;
                case "updated":
                    result.append("  - ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("oldValue"))
                            .append("\n");
                    result.append("  + ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("newValue"))
                            .append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown difference type:  " + differences);
            }
        }
        return result.append("}").toString();
    }
}
