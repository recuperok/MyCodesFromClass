//Kevin Recupero
//Advanced Data Structures
//Original intent of program was to print out a String in reverse
//I added the factor of determining whether the reverse String is a palindrome or not
package w4_C5_17;
import java.util.Scanner;

public class Reversing_Words {
	public static String word = "m p";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the word you would like to reverse: " );
		word = sc.nextLine();
		new Reversing_Words().reverseIt(word.length());
		sc.close();
	}
	
	public void reverseIt(int x) {
		String reverseWord = "";
		if (x > 0) {
			//System.out.print(word.charAt(x - 1)); Original intent
			reverseWord = reverseWord + word.charAt(x - 1);
			reverseIt(x - 1); // recursive case
		}else {
			// base case
		}
		System.out.print(reverseWord);
		if (reverseWord.contentEquals(word)) {
			System.out.print("The word " + word + " is a palindrome.");
		}else {
			//System.out.println("nope");
		}
	}
}