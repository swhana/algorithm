import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();   //tc
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i < 101; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            System.out.println(dp[N]);
        }
    }
}