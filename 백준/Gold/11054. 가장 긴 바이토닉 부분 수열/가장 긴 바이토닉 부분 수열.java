import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp_left = new int[N];
        int[] dp_right = new int[N];
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp_left[i] = 1;
            dp_right[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp_left[i] < dp_left[j] + 1) {
                    dp_left[i] = dp_left[j] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && dp_right[i] < dp_right[j] + 1) {
                    dp_right[i] = dp_right[j] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            dp_left[i] += dp_right[i];

            if (dp_left[i] > max)
                max = dp_left[i];
        }

        System.out.println(max - 1);
    }
}