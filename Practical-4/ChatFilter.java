import java.util.Locale;
public class ChatFilter {
    private static final String[] BLOCKED_WORDS = {"spamword", "badword"};
    static String filter(String message) {
        String result = message;
        for (String word : BLOCKED_WORDS) {
            result = result.replaceAll("(?i)" + java.util.regex.Pattern.quote(word), "***");
        }
        return result;
    }
    public static void main(String[] args) {
        String message = "This message contains a SpamWord.";
        System.out.println(filter(message));
    }
}
