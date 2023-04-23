import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		//동전의 배열
		int[] coin = new int[n];
		
		for(int i=0; i<n; i++) coin[i] = sc.nextInt();
		
		int[] dp = new int[k+1]; //동전의 합의 경우의 수를 담은 dp배열
		
		dp[0] = 1; //가장 작은 동전
		
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
