import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] stairs = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            stairs[i] = sc.nextInt();
        }

        if (N > 0)
            result[0] = stairs[0];
        if (N > 1)
            result[1] = stairs[0] + stairs[1];
        if (N > 2)
            result[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        if (N > 3) {
            for (int i = 3; i < N; i++) {
                result[i] = Math.max(result[i - 2] + stairs[i], result[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }

        System.out.println(result[N - 1]);
    }
}