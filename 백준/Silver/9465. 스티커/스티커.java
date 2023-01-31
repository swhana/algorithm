import java.util.Scanner;

/**
 * o x o dp[a][0]
 * x o x dp[a][1]
 *
 * dp[a][0] = Max(dp[a-1][1], dp[a-2][1]) + arr[a][0]
 * dp[a][1] = Max(dp[a-1][0], dp[a-2][0]) + arr[a][1]
 *
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();

            int[][] arr = new int[N+1][2];

            int[][] dp = new int[N+1][2];

            for(int i=0; i<N; i++){
                arr[i][0] = sc.nextInt();
            }
            for(int i=0; i<N; i++){
                arr[i][1] = sc.nextInt();
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];

            dp[1][0] = arr[0][1] + arr[1][0];
            dp[1][1] = arr[0][0] + arr[1][1];

            if(N>=2){
            for(int i=2; i<=N; i++){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + arr[i][0];
                dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]) + arr[i][1];
            }}

            System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));

        }
    }
}
