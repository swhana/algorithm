import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] dp_max = new int[N][3];
        int[][] dp_min = new int[N][3];
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        dp_max[0][0] = arr[0][0];
        dp_min[0][0] = arr[0][0];
        dp_max[0][1] = arr[0][1];
        dp_min[0][1] = arr[0][1];
        dp_max[0][2] = arr[0][2];
        dp_min[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            dp_max[i][0] = Math.max(dp_max[i - 1][0], dp_max[i - 1][1]) + arr[i][0];
            dp_min[i][0] = Math.min(dp_min[i - 1][0], dp_min[i - 1][1]) + arr[i][0];
            dp_max[i][1] = Math.max(Math.max(dp_max[i - 1][0], dp_max[i - 1][1]), dp_max[i - 1][2]) + arr[i][1];
            dp_min[i][1] = Math.min(Math.min(dp_min[i - 1][0], dp_min[i - 1][1]), dp_min[i - 1][2]) + arr[i][1];
            dp_max[i][2] = Math.max(dp_max[i - 1][1], dp_max[i - 1][2]) + arr[i][2];
            dp_min[i][2] = Math.min(dp_min[i - 1][1], dp_min[i - 1][2]) + arr[i][2];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            if (dp_max[N - 1][i] > max)
                max = dp_max[N - 1][i];
            if (dp_min[N - 1][i] < min)
                min = dp_min[N - 1][i];
        }

        System.out.println(max + " " + min);

    }
}