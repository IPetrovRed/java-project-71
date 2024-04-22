package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {

    public static String plainFormatter(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> diff : differences) {
            switch (diff.get("type").toString()) {
                case "equals":
                    break;
                case "deleted":
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was deleted")
                            .append("\n");
                    break;
                case "added":
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was added with value: ")
                            .append(checkValue(diff.get("newValue")))
                            .append("\n");
                    break;
                case "changed":
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was changed. From ")
                            .append(checkValue(diff.get("oldValue")))
                            .append(" to ")
                            .append(checkValue(diff.get("newValue")))
                            .append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown difference");
            }
        }
        return result.toString().trim();
    }

    public static String checkValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
