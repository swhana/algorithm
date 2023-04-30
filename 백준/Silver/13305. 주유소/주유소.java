import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dist = new int[N-1]; //도시간 거리
		int[] price = new int[N];
		long cost = 0;
		
		for(int i=0; i<N-1; i++) dist[i] = sc.nextInt();		
		for(int i=0; i<N; i++) price[i] = sc.nextInt();
		
		int p = price[0];
		for(int i=0; i<N-1; i++) {
			if(p > price[i]) p = price[i];
			
			cost += p * dist[i];
		}
		
		System.out.println(cost);
	}

}
