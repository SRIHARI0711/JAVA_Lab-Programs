package pswrd_scrty_app;
import java.util.*;

public class passSecurity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a password:");
        String password = sc.nextLine();

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        int spec_characters = 0;

        // Analyze each character
        for(char ch: password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                spec_characters++;
            }
        }

        // ✅ Now print only once after analysis
        System.out.println("\nPassword check in progress...");
        System.out.println("password has uppercase letters: " + hasUpperCase);
        System.out.println("password has lowercase letters: " + hasLowerCase);
        System.out.println("password has digits: " + hasDigit);
        System.out.println("password has special characters: " + spec_characters);

        // Masking
        String masked_password;
        if (password.length() <= 2) {
            masked_password = password;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(password.charAt(0));
            for (int i = 1; i < password.length() - 1; i++) {
                sb.append('*');
            }
            sb.append(password.charAt(password.length() - 1));
            masked_password = sb.toString();
        }
        System.out.println("Masked password is: " + masked_password);

        // Reversed password
        String reversed_password = new StringBuilder(password).reverse().toString();
        System.out.println("Reversed password is: " + reversed_password);

        // Secure password with random token
        int randN = (int) (Math.random() * 1001);
        String token = "@" + randN + "!";
        String secured_password = password + token;
        System.out.println("Secured password is: " + secured_password);

        // Replace vowels with #
        StringBuilder sb2 = new StringBuilder(password);
        for (int i = 0; i < sb2.length(); i++) {
            char ch1 = Character.toLowerCase(sb2.charAt(i));
            if (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') {
                sb2.setCharAt(i, '#');
            }
        }
        System.out.println("Password (with vowels replaced): " + sb2);
    }
}
