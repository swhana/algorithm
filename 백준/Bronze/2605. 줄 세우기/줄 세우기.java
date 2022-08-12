import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			list.add(arr[i], i + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = list.size() - 1; i >= 0; i--)
			sb.append(list.get(i) + " ");

		System.out.println(sb);
	}

}