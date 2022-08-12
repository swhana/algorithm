import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[5][5];
		int[][] que = new int[5][5];
		boolean[][] chk = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				que[i][j] = sc.nextInt();
			}
		}
		//////////// 입력 끝///////////////
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						// 일치하는 값을 빙고판에서 찾았을 경우
						if (que[i][j] == arr[r][c]) {
							chk[r][c] = true;

							if (bingo(chk, 5) >= 3) {
								System.out.println(i * 5 + j + 1);
								return;
							}
						}
					}
				}
			}
		}

	}

	// 빙고 개수 출력
	static int bingo(boolean[][] arr, int N) {
		int count;
		int res = 0;

		// 가로방향 빙고찾기
		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == true)
					count++;
				else
					count = 0;
			}
			if (count == 5)
				res++;
		}

		// 세로방향 빙고찾기
		for (int j = 0; j < N; j++) {
			count = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i][j] == true)
					count++;
				else
					count = 0;
			}
			if (count == 5)
				res++;
		}

		// 좌상->우하로 가는 대각선
		count = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i][i] == true)
				count++;
			else
				count = 0;

		}
		if (count == 5)
			res++;

		// 좌하->우상으로 가는 대각선
		count = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i][N - 1 - i] == true)
				count++;
			else
				count = 0;

		}
		if (count == 5)
			res++;

		return res;
	}
}