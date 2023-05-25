import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();

			int[][] dp = new int[10001][4];
			/*
			 * 모든 수식은 오름차순으로 정렬되어있는 것을 전제로 한다. (1 + 1 + 2 + 3은 되지만 1 + 1 + 3 + 2는 고려안함)
			 * dp[n][1] = n을 구성하는 합중 1로 끝나는 조합 ( ... + 1) => 1로만 구성되어 있다는 소리 dp[n][2] = 2로
			 * 끝나는 조합 dp[n][3] = 3으로 끝나는 조합
			 */
			// 초기 설정
			dp[1][1] = 1;
			dp[1][2] = 0; // 1은 수식에 2를 넣을 수 없다
			dp[1][3] = 0; // 마찬가지

			dp[2][1] = 1;
			dp[2][2] = 1; // 2 하나
			dp[2][3] = 0; // 없음

			dp[3][1] = 1;
			dp[3][2] = 1; // 1+2 하나 -> 사실 dp[1][2]라고 봐도 됨
			dp[3][3] = 1; // 3 하나

			if (n > 3) {
				for (int i = 4; i < n + 1; i++) {
					dp[i][1] = 1; // 1+1+1+1...+1밖에 없음
					dp[i][2] = dp[i - 2][1] + dp[i - 2][2]; // 2를 뺀 경우의 수에서 1로 끝나는 경우와 2로 끝나는 경우에 한정
					dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
				}
			}

			System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
		}
	}
}
