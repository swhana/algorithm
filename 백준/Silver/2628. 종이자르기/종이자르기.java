import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		int N = sc.nextInt();

		int[][] arr = new int[N][2];

		ArrayList<Integer> arr0 = new ArrayList();
		ArrayList<Integer> arr1 = new ArrayList();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][0] == 0)
					arr0.add(arr[i][1]);
				else
					arr1.add(arr[i][1]);
			}
		}

		arr0.add(y);
		arr0.add(0);
		arr1.add(x);
		arr1.add(0);

		Collections.sort(arr0);
		Collections.sort(arr1);

		int max_arr0 = -1;
		int max_arr1 = -1;
		for (int i = 0; i < arr0.size() - 1; i++) {
			max_arr0 = Math.max(max_arr0, arr0.get(i + 1) - arr0.get(i));
		}

		for (int i = 0; i < arr1.size() - 1; i++) {
			max_arr1 = Math.max(max_arr1, arr1.get(i + 1) - arr1.get(i));
		}

		System.out.println(max_arr0 * max_arr1);
	}

}