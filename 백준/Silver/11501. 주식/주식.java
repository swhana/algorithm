import java.util.*;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt(); //Test case
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //날의 수
			int[] stock = new int[N]; //날별 주가 배열
			for(int i=0; i<N; i++) stock[i] = sc.nextInt();

			long profit = 0; //이익
			
			int max = 0;
			for(int i=N-1; i>=0; i--) {
				if(stock[i] > max) {
					max = stock[i]; //최대값 교체
				} else {
					profit += max - stock[i];
				}
			}
			sb.append(profit).append("\n");
		}
		System.out.print(sb);
		
	}
}
