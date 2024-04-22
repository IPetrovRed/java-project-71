package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String stylishFormatter(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> diff : differences) {
            switch (diff.get("type").toString()) {
                case "deleted":
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
                default:
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
            }
        }
        return result.append("}").toString();
    }
}
