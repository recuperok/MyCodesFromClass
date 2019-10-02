package hw1;

import java.util.Scanner;

public class R1_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R1_3 r;
		r = new R1_3();
		
		int choice = 15;
		while (choice != 0){
			String cont;
			System.out.println("Here are some choices for this program: ");
			System.out.println("0. Ends the program");
			System.out.println("1. This is a multiple checker that is hard coded");
			System.out.println("2. A multiple checker with user input");
			System.out.println("3. Multiplier");
			System.out.println("Please enter the option you'd like to run: ");
			choice = sc.nextInt();
			if (choice == 1) {
				// this line along with top 3 lines are from my class. I have added to the code
				System.out.println(r.isMultiple(8, 2));
			}else if(choice == 2) {
				// code I added on
				long bigger = 0;
				long isMultiple = 0;
				
				System.out.println("Enter first number: ");
				bigger = sc.nextLong();
				System.out.println("Enter second number: ");
				isMultiple = sc.nextLong();
				if (r.isMultiple(bigger, isMultiple) == false) {
					System.out.println("The number " + isMultiple + " is not a multiple of " + bigger);
				}else {
					long result;
					result = bigger / isMultiple;
					System.out.println("The number " + isMultiple + " goes into " + bigger + ", " + result + " times.");
				}
			}else if(choice == 3) {
				long firstNum = 0;
				long secNum = 0;
				
				System.out.println("Enter the first number: ");
				firstNum = sc.nextLong();
				System.out.println("Enther the second number: ");
				secNum = sc.nextLong();
				
				System.out.println(firstNum + " x " + secNum + "  = " + firstNum * secNum);
			}
			System.out.println("Would you like to continue? (Y/N): ");
			cont = sc.next();
			if (!cont.toLowerCase().equals("y")) {
				break;
			}
		}
		sc.close();
	}
	
	public boolean isMultiple(long n, long m) {
		for (int i = 0; i < n; i++) {
			if (i * m == n) {
				return true;
			}
		}
		return false;
	}

}
