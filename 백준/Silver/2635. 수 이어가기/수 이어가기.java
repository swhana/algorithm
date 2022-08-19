import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		StringBuilder max = new StringBuilder();

		int count = 0;
		int max_count = 0;
		for (int i = 0; i <= N; i++) {
			StringBuilder sb = new StringBuilder();
			count = 2;
			sb.append(N + " ");
			sb.append(i + " ");

			int x = N;
			int y = i;
			while (x - y >= 0) {
				int temp = y;
				y = x - y;
				x = temp;
				sb.append(y + " ");
				count++;
			}
			if (max.length() < sb.length()) {
				max = sb;
				max_count = count;
			}
		}
		System.out.println(max_count);
		System.out.println(max);

	}

}