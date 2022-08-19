import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 입력받을 기둥 개수
		int[][] LH = new int[N][2];

		int maxH = -1;
		for (int i = 0; i < N; i++) {
			LH[i][0] = sc.nextInt(); // 위치
			LH[i][1] = sc.nextInt(); // 높이

			maxH = Math.max(maxH, LH[i][1]);
		}

		// 위치 순 정렬
		Arrays.sort(LH, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1[0] - arr2[0];
			}
		});

		int a = 0;
		int b = 0;
		int sum = 0;
		int height = -1;
		for (int i = 0; i < N; i++) {
			height = Math.max(LH[i][1], height);
			if (height == maxH) {
				a = LH[i][0];
				break;
			}
			sum += height * (LH[i + 1][0] - LH[i][0]);
		}

		height = -1;
		for (int i = N - 1; i >= 0; i--) {
			height = Math.max(LH[i][1], height);
			if (height == maxH) {
				b = LH[i][0];
				break;
			}

			sum += height * (LH[i][0] - LH[i - 1][0]);
		}

		sum += maxH * (b - a + 1);

		System.out.println(sum);
	}

}