package w3_p3_30;

import java.util.Scanner;

public class Caesar_Cipher {

	public static void main(String[] args) {
		int encryLeng = 0;
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String phrase = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the cipher length: ");
		encryLeng = sc.nextInt();
		System.out.println("Please enter the phrase you would like to encrypt: ");
		phrase = sc.next();
		
		for (int y = 0; y < alpha.length(); y++) {
			for (int x = 0; x < phrase.length(); x++) {
				if (phrase.charAt(x) == alpha.charAt(y)) {
					phrase = phrase.replace(phrase.charAt(x), alpha.charAt(y + encryLeng));
				}else {
					break;
				}
				//phrase.replace(phrase.charAt(x), newChar)charAt(x);
			}
		}
		System.out.println(phrase);
	sc.close();	
	}
}