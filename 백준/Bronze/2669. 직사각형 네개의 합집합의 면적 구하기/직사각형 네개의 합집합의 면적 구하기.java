import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] rec = new int[4][4];
		int[][] map = new int[101][101];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				rec[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				for (int r = rec[i][0]; r < rec[i][2]; r++) {
					for (int c = rec[i][1]; c < rec[i][3]; c++) {
						map[r][c]++;
					}
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[i][j] != 0)
					cnt++;
			}
		}

		System.out.println(cnt);
	}

}