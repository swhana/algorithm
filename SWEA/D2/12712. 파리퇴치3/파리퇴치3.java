import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int[] dxx = { 1, 1, -1, -1 };
		int[] dyy = { 1, -1, -1, 1 };

		int T = sc.nextInt();

		for (int m = 1; m <= T; m++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int max = -1;
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {
					// 모든 좌표에 대해

					int sum = arr[i][j];

					// 가로세로 뿌리기

					// 좌표 방향
					for (int k = 0; k < 4; k++) {
						// 물의 세기
						for (int l = 1; l < M; l++) {
							int nx = i + l * dx[k];
							int ny = j + l * dy[k];
							if (nx >= 0 && nx < N && ny >= 0 && ny < N)
								sum += arr[nx][ny];
						}
					}

					if (max < sum)
						max = sum;
					// 대각선 뿌리기
					sum = arr[i][j];

					for (int k = 0; k < 4; k++) {
						for (int l = 1; l < M; l++) {
							int nx = i + l * dxx[k];
							int ny = j + l * dyy[k];
							if (nx >= 0 && nx < N && ny >= 0 && ny < N)
								sum += arr[nx][ny];
						}
					}

					if (max < sum)
						max = sum;
				}
			}

			System.out.println("#" + m + " " + max);
		}
	}

}