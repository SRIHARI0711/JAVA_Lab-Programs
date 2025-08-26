package String_ops;
//import String_ops.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringProcessor s = new StringProcessor();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        System.out.println("\nString Operation results for: "+input);
        System.out.println("Uppercase: " + s.toUpperCase(input));
        System.out.println("Lowercase: " + s.toLowerCase(input));
        System.out.println("Reversed: " + s.reverse(input));
        System.out.println("Is Palindrome: " + s.isPalindrome(input));
        System.out.println("Word Count: " + s.wordCount(input));
        System.out.println("Vowel Count: " + s.countVowels(input));

        System.out.println("\nEnter another string to concatenate:");
        String input2 = sc.nextLine();
        System.out.println("Concatenated String: " + s.concatenate(input, input2));
    }    
}
