import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.nextLine();
		char[] ns = N.toCharArray();

		int n = 0;
		int j = 0;
		while(n++ <= 30000) {
			String str = String.valueOf(n);

			for(int i=0; i<str.length(); i++) {				
				//잘린 문자열 일치하면 그다음 문자
				if(ns[j] == str.charAt(i)) {
					j++;
				}
				if(j == ns.length) {
					System.out.println(n);
					return;
				}
			}
		}
	}
}
