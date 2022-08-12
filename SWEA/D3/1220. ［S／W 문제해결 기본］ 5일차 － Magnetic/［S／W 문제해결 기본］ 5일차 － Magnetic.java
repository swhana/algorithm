import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int k = 1; k <= 10; k++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			List<Integer> arr = new ArrayList<Integer>();

			int count = 0;
			for (int i = 0; i < N; i++) {
				arr.clear();
				for (int j = 0; j < N; j++) {
					if (map[j][i] != 0)
						arr.add(map[j][i]);

				}

				for (int j = 0; j < arr.size() - 1; j++) {
					if (arr.get(j) == 1 && arr.get(j + 1) == 2)
						count++;
				}

			}

			System.out.println("#" + k + " " + count);
		}
	}

}