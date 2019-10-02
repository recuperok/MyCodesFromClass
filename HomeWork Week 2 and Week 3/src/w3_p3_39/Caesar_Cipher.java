package w3_p3_39;

import java.util.Scanner;

public class Caesar_Cipher {
	Scanner sc = new Scanner(System.in); //scanner for inputs
	
	public static void main(String[] args) {
		new Caesar_Cipher().doIt();
	}
	
	public void doIt() {
		int encryLeng = 0;   //this is how far the encryption will go
		String middle = "";  // this is the holder for a single letter in a the string to encrypt
		String phrase = ""; // this is the phrase that will be changed
		String encryptMessage = "";  //this is the encrypted result
		String alpha = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"; 
		
		System.out.println("Please enter the cipher length: ");
		encryLeng = sc.nextInt();
		System.out.println("Please enter the phrase you would like to encrypt: ");
		phrase = sc.next();
		
		phrase = phrase + sc.nextLine();
		System.out.println(phrase);
		while(encryLeng > 26) {
			encryLeng = encryLeng - 26;
		}
		System.out.println(encryLeng);
		for (int x = 0; x < phrase.length(); x++) {
			for (int y = 0; y < 26; y++) {
				if (phrase.charAt(x) == alpha.charAt(y)) {    												// this is for lower case letters
					middle = phrase.substring(x, x + 1);                                    				// middle takes one letter in the string
					middle = middle.replace(middle.charAt(0), alpha.charAt(y + encryLeng));				    // it then changes that letter based on the encryption length
					encryptMessage = encryptMessage + middle;                								// finally it adds it onto the encrypted message
					break; 
				}else if (phrase.charAt(x) == alpha.toUpperCase().charAt(y)) {  							// this is for upper case letters
					middle = phrase.substring(x, x + 1); 
					middle = middle.replace(middle.charAt(0), alpha.toUpperCase().charAt(y + encryLeng));
					encryptMessage = encryptMessage + middle;
					break;
				}else if (phrase.charAt(x) == ' ' || phrase.charAt(x) == '?' || phrase.charAt(x) == '!' || phrase.charAt(x) == '.') {  // this is for some punctuation
					encryptMessage = encryptMessage + phrase.charAt(x);
					break;
				}
			}
		}
		System.out.println(encryptMessage); // prints the message here
	}
}