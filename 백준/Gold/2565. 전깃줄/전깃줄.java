import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            각 index별로 LIS를 구해서 가장 긴 경우의 값을 전체 전봇대 수 N에서 빼주면 된다
         */

        int N = sc.nextInt();

        int[][] arr = new int[N][2];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();   //A전봇대 번호
            arr[i][1] = sc.nextInt();   //B전봇대 번호
        }

        //A전봇대 번호 순으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            dp[i] = 1;  //기본은 1로 초기화

            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(N - max);

    }
}