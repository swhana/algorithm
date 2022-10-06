import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[] fibo_0 = new int[41];
            int[] fibo_1 = new int[41];

            fibo_0[0] = 1;
            fibo_0[1] = 0;
            fibo_1[0] = 0;
            fibo_1[1] = 1;

            for (int i = 2; i <= N; i++) {
                fibo_0[i] = fibo_0[i - 1] + fibo_0[i - 2];
                fibo_1[i] = fibo_1[i - 1] + fibo_1[i - 2];
            }

            System.out.println(fibo_0[N] + " " + fibo_1[N]);
        }
    }
}