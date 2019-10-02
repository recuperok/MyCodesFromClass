package c2_21;

public class Code1 {

	public static void main(String[] args) {
		C cnx = new C();
		B bnx = new B();
		cnx.setXA(12);
		System.out.println(cnx.getXA());
		System.out.println("B: "+ bnx.getXInB()); // to prove that b is still the same
	}

}
class A {
    int x = 5;
    public void setAX(int aX) {
        x = aX;
    }
    public int getAX() {
        return x;
    }
}

class B extends A 
{
    int x = 4;
    public void setBx(int aX) {
        x = aX;
    }
    public int getXInB() {
        return x;
    }

}

class C extends B {
    int x = 3;
    public void setXA(int aX) {
        super.setAX(aX); // this is setting the x value in the super class A
    }

    public int getXA() {
        return super.getAX(); // This is returning the super class A integer x
    }
}