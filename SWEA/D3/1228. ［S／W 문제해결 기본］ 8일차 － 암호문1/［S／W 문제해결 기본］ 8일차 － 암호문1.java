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

			// 특정 위치부터 추가해주면 됨
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

			// 출력이 암호문 10개 제한인거에만 주의
			for (int i = 0; i < 10; i++) {
				sb.append(list.poll());
			}
			System.out.println(sb);
		}
	}

}