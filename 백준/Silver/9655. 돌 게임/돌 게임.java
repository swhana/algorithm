import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		switch(N%4) {
			case 0: {
				System.out.println("CY");
				return;
			}
			case 1: {
				System.out.println("SK");
				return;
			}
			case 2: {
				System.out.println("CY");
				return;
			}
			case 3: {
				System.out.println("SK");
				return;
			}
		}
	}

}
