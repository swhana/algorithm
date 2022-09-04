import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;

    static int binary_search(int value, int start, int end) {
        if (start > end)
            return 0;

        int mid = (start + end) / 2;

        if (value == arr[mid])
            return 1;

        else if (value < arr[mid])
            return binary_search(value, start, mid - 1);

        else
            return binary_search(value, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int val = sc.nextInt();

            System.out.println(binary_search(val, 0, N - 1));
        }
    }
}