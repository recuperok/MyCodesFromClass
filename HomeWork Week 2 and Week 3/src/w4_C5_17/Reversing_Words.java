package w4_C5_17;

import java.util.Scanner;

public class Reversing_Words {
	public static String word = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the word you would like to reverse: " );
		word = sc.next();
		new Reversing_Words().reverseIt(word.length());
		sc.close();
	}
	
	public void reverseIt(int x) {
		if (x > 0) {
			System.out.print(word.charAt(x - 1));
			reverseIt(x - 1); // recursive case
		}else {
			// base case
		}
	}
}