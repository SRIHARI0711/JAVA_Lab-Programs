package Palindrome_checker;
import java.util.*;
class InvalidInputException extends Exception{
	public InvalidInputException(String message) {
		super(message);
	}
}
//Custom exception for short strings
class ShortStringException extends Exception{
	public ShortStringException(String message) {
		super(message);
	}
}
public class PalindromeChecker {
	public static void validateInput(String str) throws InvalidInputException, ShortStringException{
		if (!str.matches("[a-zA-Z]+")) {
			throw new InvalidInputException("Input must contain only alphabetic characters.");
		}
		if(str.length() < 3) {
			throw new ShortStringException("Input string must be at least 3 characters long.");
		}
	}
	public static boolean isPalindrome(String str) {
		str = str.toLowerCase(); //Ignore case
		
		StringBuffer original = new StringBuffer(str);
		StringBuffer reversed = new StringBuffer(str).reverse();
		
		return original.toString().equals(reversed.toString());
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter a string to check for a palindrome:");
			String input = scanner.nextLine();
			
			validateInput(input);
			
			if(isPalindrome(input)) {
				System.out.println("The string is a palindrome.");
			}
			else {
				System.out.println("The string is NOT a palindrome.");
			}
		}
		catch (InvalidInputException | ShortStringException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			scanner.close();
		}
	}
	
}
