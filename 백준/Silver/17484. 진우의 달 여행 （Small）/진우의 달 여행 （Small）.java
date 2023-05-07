import java.util.*;

public class Main {
	
	public static int getMin(int a, int b, int c) {
		return Math.min(Math.min(a,  b), c);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N][M];
		int[][][] dp = new int[N][M][3];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int input = sc.nextInt();
				for(int k=0; k<3; k++) dp[i][j][k] = input;
				if(i > 0) {
					if(j > 0 && j < M-1) {
						dp[i][j][0] += Math.min(dp[i-1][j-1][1], dp[i-1][j+1][2]);
						dp[i][j][1] += Math.min(dp[i-1][j][0], dp[i-1][j+1][2]);
						dp[i][j][2] += Math.min(dp[i-1][j][0], dp[i-1][j-1][1]);
					} else if(j == 0) {
						dp[i][j][0] += dp[i-1][j+1][2];
						dp[i][j][1] += Math.min(dp[i-1][j][0], dp[i-1][j+1][2]);
						dp[i][j][2] = Integer.MAX_VALUE;
					} else {
						dp[i][j][0] += dp[i-1][j-1][1];
						dp[i][j][1] = Integer.MAX_VALUE;
						dp[i][j][2] += Math.min(dp[i-1][j][0], dp[i-1][j-1][1]);
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			int rowMin = getMin(dp[N-1][i][0], dp[N-1][i][1], dp[N-1][i][2]);

			min = Math.min(rowMin,  min);
		}
		
		System.out.println(min);	
	}
}
