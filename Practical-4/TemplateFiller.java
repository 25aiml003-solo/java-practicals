import java.util.Map;
public class TemplateFiller {
    static String fill(String template, Map<String, String> values) {
        String result = template;
        for (Map.Entry<String, String> entry : values.entrySet()) {
            result = result.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return result;
    }
    public static void main(String[] args) {
        String template = "Hello {{name}}, your appointment is on {{date}}.";
        Map<String, String> values = Map.of("name", "Deep", "date", "Monday");
        System.out.println(fill(template, values));
    }
}
