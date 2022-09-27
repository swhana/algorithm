import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] W = new int[N + 1];   //weight
        int[] V = new int[N + 1];   //value
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (W[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = V[i] + dp[i - 1][j - W[i]] > dp[i - 1][j] ? V[i] + dp[i - 1][j - W[i]] : dp[i - 1][j];
            }
        }

        System.out.println(dp[N][K]);

    }
}