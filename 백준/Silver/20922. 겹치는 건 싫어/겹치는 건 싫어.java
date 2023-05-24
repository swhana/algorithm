import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[200000];
		int[] count = new int[100001];

		int max = Integer.MIN_VALUE;
		int lp = 0;
		int rp = 0;

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		while (rp < N) {
			if (count[arr[rp]] == K) {
				count[arr[lp]]--; // 연속 부분수열의 맨 왼쪽 원소부터 제외
				lp++;
			} else {
				count[arr[rp]]++;
				rp++;
			}
			max = Math.max(max, rp - lp);
		}

		System.out.println(max);
	}
}
