import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int k = 1; k <= tc; k++) {
			int N = sc.nextInt();

			// 앞 절반 받을 큐
			Queue<String> queue1 = new LinkedList();
			// 뒤 절반 받을 큐
			Queue<String> queue2 = new LinkedList();

			for (int i = 0; i < N; i++) {
				// 전체 개수가 홀수면 앞쪽 큐가 1개 더많도록
				if (i < (N + 1) / 2)
					queue1.offer(sc.next());
				else
					queue2.offer(sc.next());
			}

			StringBuilder sb = new StringBuilder();

			sb.append("#" + k + " ");
			for (int i = 0; i < N; i++) {
				// 하나씩 번갈아가면서 추출
				if (i % 2 == 0)
					sb.append(queue1.poll() + " ");
				else
					sb.append(queue2.poll() + " ");
			}

			System.out.println(sb);
		}

	}

}