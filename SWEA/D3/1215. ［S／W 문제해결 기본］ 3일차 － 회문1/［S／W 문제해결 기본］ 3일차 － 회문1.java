import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 찾아야 하는 회문의 길이

			String[] m = new String[8];
			char[][] map = new char[8][8];

			for (int i = 0; i < 8; i++) {
				m[i] = br.readLine();
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					map[i][j] = m[i].charAt(j);
				}
			}

			int count = 0;
			int total = 0;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					count = 0;
					for (int r = 0; r < (N + 1) / 2; r++) {
						if (i + r < 8 && i + N - 1 - r < 8) {
							if (map[i + r][j] == map[i + N - 1 - r][j])
								count++;
						}
					}
					if (count == (N + 1) / 2)
						total++;

					count = 0;
					for (int r = 0; r < (N + 1) / 2; r++) {
						if (j + r < 8 && j + N - 1 - r < 8) {
							if (map[i][j + r] == map[i][j + N - 1 - r])
								count++;
						}
					}
					if (count == (N + 1) / 2)
						total++;

				}
			}

			System.out.println("#" + tc + " " + total);
		}

	}

}