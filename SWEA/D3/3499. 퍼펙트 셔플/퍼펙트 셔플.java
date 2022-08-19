import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int k = 1; k <= tc; k++) {
			int N = sc.nextInt();

			Queue<String> queue1 = new LinkedList();
			Queue<String> queue2 = new LinkedList();

			for (int i = 0; i < N; i++) {
				if (i < (N + 1) / 2)
					queue1.offer(sc.next());
				else
					queue2.offer(sc.next());
			}

			StringBuilder sb = new StringBuilder();

			sb.append("#" + k + " ");
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0)
					sb.append(queue1.poll() + " ");
				else
					sb.append(queue2.poll() + " ");
			}

			System.out.println(sb);
		}

	}

}