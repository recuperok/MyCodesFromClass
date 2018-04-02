package p2_30;

import java.io.FileInputStream;
import java.io.IOException;

public class Code {
	static String alpha = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		Code c = new Code();
		String document = "";
		try {
			FileInputStream fis =new FileInputStream("Homework.txt");
			byte[] buffer = new byte[10];
			StringBuilder sb = new StringBuilder();
			while (fis.read(buffer) != -1) {
				sb.append(new String(buffer));
				buffer = new byte[10];
			}
			fis.close();
			document = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		for (int x = 0; x < alpha.length(); x++){
			System.out.println(alpha.charAt(x)+": " + c.chart(c.letterCheck(document)[x]));
		}
		
	}
	
	public int[] letterCheck(String d) {
		
		char l;
		int counter[] = new int[26];
		for (int y = 0; y < alpha.length(); y++) {
			l = alpha.charAt(y);
			for(int x = 0; x < d.length(); x++) {
				//System.out.println(x);
				if (d.charAt(x) == l) {
					counter[y]++;
				}
			}
		}
		return counter;
	}
	public String chart(int count) {
		String charter = "";
		for (int x = 0; x < count; x++) {
			charter = charter + "#";
		}
		return charter;
	}
}
