import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i > 0 && j > 0)
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + arr[i][j];
                else if (i == 0 && j > 0) {
                    dp[i][j] = arr[i][j] + dp[i][j - 1];
                } else if (i > 0 && j == 0) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}