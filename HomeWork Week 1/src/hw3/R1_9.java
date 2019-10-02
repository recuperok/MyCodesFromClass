package hw3;

public class R1_9 {

	public static void main(String[] args) {
		R1_9 r;
		r = new R1_9();
		
		System.out.println(r.strDestroyer("Let's try, Mike!"));

	}
	
	public String strDestroyer(String s) {
		String f;
		f = s.replaceAll("[!,']", "");
		return f;
	}


}
