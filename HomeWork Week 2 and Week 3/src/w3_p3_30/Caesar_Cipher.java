package w3_p3_30;

import java.util.Scanner;

public class Caesar_Cipher {

	public static void main(String[] args) {
		int encryLeng = 0;
		char blank = 0;
		String alpha = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String phrase = "";
		String holdE = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the cipher length: ");
		encryLeng = sc.nextInt();
		System.out.println("Please enter the phrase you would like to encrypt: ");
		phrase = sc.next();
		//first loop checks for letter
		//System.out.println(alpha.charAt(y));
		int counter = 0;
		for (int y = 0; y < 26; y++) {
			//System.out.println(y);
			for (int x = 0; x < phrase.length(); x++) {
				if (phrase.charAt(x) == alpha.charAt(y)) {
					//System.out.println(y + encryLeng);
					holdE = phrase.replace(phrase.charAt(x), alpha.charAt((int) (y + encryLeng)));
					phrase.replace(holdE.charAt(x), blank);
					counter++;
				}else {
					
				}
			}
		
				
			//phrase.replace(phrase.charAt(x), newChar)charAt(x);
		}
		System.out.println(holdE);
	sc.close();	
	}
}