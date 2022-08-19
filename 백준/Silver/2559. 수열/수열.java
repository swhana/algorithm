import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		max = sum;

		for (int i = 0; i < N - K; i++) {
			sum -= arr[i];
			sum += arr[i + K];

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}

}