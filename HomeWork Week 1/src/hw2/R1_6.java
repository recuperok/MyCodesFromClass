package hw2;

import java.util.Scanner;

public class R1_6 {

	public static void main(String[] args) {
		R1_6 r;
		r = new R1_6();
		Scanner sc = new Scanner(System.in);
		System.out.println(r.sumOfNums(8, 2, 0));
		int num = 0;
		int choice = 15;
		while (choice != 0){
			String cont;
			System.out.println("Here are some options for this code.");
			System.out.println("0. End the program");
			System.out.println("1. Add all the preceding numbers together");
			System.out.println("2. Add all the preceding even numbers");
			System.out.println("3. Add all the preceding odd numbers");
			System.out.println("Please enter the option you'd like to run: ");
			choice = sc.nextInt();
			System.out.println("Please enter the number to add to: ");
			num = sc.nextInt();
			
			if (choice == 0) {
				break;
			}else if(choice == 1) {
				System.out.println(r.sumOfNums(num, 1, 0));
			}else if (choice == 2) {
				System.out.println(r.sumOfNums(num, 2, 0));
			}else if (choice == 3) {
				System.out.println(r.sumOfNums(num, 2, 1));
			}
			System.out.println("Would you like to continue? (Y/N): ");
			cont = sc.next();
			if (!cont.toLowerCase().equals("y")) {
				break;
			}
		}
		
		sc.close();
	}
	
	public int sumOfNums(int n, int num, int star) {
		int sum;
		sum = 0;
		for (int i = star; i <= n; i = i + num) {
			System.out.println(sum);
			sum = sum + i;
		}
		return sum;		
	}
}
