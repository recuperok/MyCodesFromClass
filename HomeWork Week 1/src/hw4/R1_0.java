package hw4;

import java.util.Scanner;

public class R1_0 {
	String fName;
	int numPetals;
	float fPrice;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		R1_0 r;
		r = new R1_0();
		
		System.out.printf("Input the name of the flower: ");
		r.setfName(s.next());
		System.out.printf("Input the number of Petals on the flower: ");
		r.setNumPetals(s.nextInt());
		System.out.println("Input the price of the flower: ");
		r.setfPrice(s.nextFloat());
		
		System.out.printf("The "+ r.getfName() + " has "+ r.getNumPetals() +" petals, and it costs $"+ String.format("%.2f", r.getfPrice()));
		
		s.close();
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public int getNumPetals() {
		return numPetals;
	}
	public void setNumPetals(int numPetals) {
		this.numPetals = numPetals;
	}
	public float getfPrice() {
		return fPrice;
	}
	public void setfPrice(float fPrice) {
		this.fPrice = fPrice;
	}
}
