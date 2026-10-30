import java.util.Scanner;
public class PasswordChecker {
    private static final int MIN_LENGTH = 8;
    static boolean isStrong(String password) {
        boolean upper = false, lower = false, digit = false, special = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) upper = true;
            else if (Character.isLowerCase(ch)) lower = true;
            else if (Character.isDigit(ch)) digit = true;
            else special = true;
        }
        return password.length() >= MIN_LENGTH && upper && lower && digit && special;
    }
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter password: ");
            System.out.println(isStrong(input.nextLine()) ? "Strong password" : "Weak password");
        }
    }
}
