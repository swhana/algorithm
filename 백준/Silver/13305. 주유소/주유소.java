import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] dist = new long[N-1]; //도시간 거리
		long[] price = new long[N]; //도시에서 리터당 기름가격
		long cost = 0; //비용
		
		for(int i=0; i<N-1; i++) dist[i] = sc.nextInt();		
		for(int i=0; i<N; i++) price[i] = sc.nextInt();
		
		//제일 싼 곳의 가격을 생각
		long p = price[0];
		for(int i=0; i<N-1; i++) {
			if(p > price[i]) p = price[i];
			cost += p * dist[i];
		}
		
		System.out.println(cost);
	}

}
