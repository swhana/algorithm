import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int k = 1; k <= 10; k++) {
			int N = sc.nextInt();

			LinkedList<String> list = new LinkedList();

			for (int i = 0; i < N; i++) {
				list.add(sc.next() + " ");
			}

			int C = sc.nextInt();

			for (int i = 0; i < C; i++) {
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for (int j = x; j < x + y; j++) {
					list.add(j, sc.next() + " ");
				}
			}

			StringBuilder sb = new StringBuilder();

			sb.append("#" + k + " ");

			for (int i = 0; i < 10; i++) {
				sb.append(list.poll());
			}
			System.out.println(sb);
		}
	}

}