import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		double a = (double)H/(N+1);
		double b = (double)W/(M+1);

		System.out.println((int)(Math.ceil(a) * Math.ceil(b)));
	}
}
