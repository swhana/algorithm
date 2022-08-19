import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int k = 1; k <= 10; k++) {
			int N = sc.nextInt(); // 원본 암호문 길이 N

			LinkedList<String> list = new LinkedList();

			// 원본 암호문
			for (int i = 0; i < N; i++) {
				list.add(sc.next() + " ");
			}

			// 명령어 개수
			int C = sc.nextInt();

			// 명령어 모음
			// 특정 위치부터 추가해주면 됨
			for (int i = 0; i < C; i++) {
				String s = sc.next();

				// x번째 위치의 원소를 y번 제거해야함에 유의
				// 원소가 하나씩 제거될 때마다 뒤쪽 값들의 index값도 달라지므로 for (int j = x; j < x + y; j++) 는 쓰면 안됨
				if (s.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				} else if (s.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = x; j < x + y; j++) {
						list.add(j, sc.next() + " ");
					}
				} else if (s.equals("A")) {
					int y = sc.nextInt();
					for (int j = 0; j < y; j++)
						list.addLast(sc.next() + " ");
				}

			}

			StringBuilder sb = new StringBuilder();

			sb.append("#" + k + " ");

			// 출력이 암호문 10개 제한인거에만 주의
			for (int i = 0; i < 10; i++) {
				sb.append(list.pop());
			}
			System.out.println(sb);
		}

	}

}