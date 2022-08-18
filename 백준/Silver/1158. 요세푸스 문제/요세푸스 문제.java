import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt(); // 전체 사람의 수
		int K = sc.nextInt(); // 건너뛰고 컷할 위치

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			list.addLast(i);
		}

		int i = K - 1;
		sb.append("<");

		while (list.size() > 0) {
			sb.append(list.remove(i));

			i += K - 1;
			if (i >= list.size() && list.size() != 0)
				i %= list.size();

			if (list.size() == 0) {
				sb.append(">");
				break;
			}

			sb.append(", ");
		}

		System.out.println(sb);
	}
}