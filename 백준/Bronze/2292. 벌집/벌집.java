import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int idx = 0;
		while(N > 0) {
			if(idx == 0) N--;
			else N -= 6*idx;
			idx++;
		}
		
		System.out.println(idx);
	}
}
