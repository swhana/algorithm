import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int k = 1; k <= 10; k++) {
			int tc = Integer.parseInt(br.readLine());

			String[] m = new String[100];
			char[][] map = new char[100][100];

			for (int i = 0; i < 100; i++) {
				m[i] = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = m[i].charAt(j);
				}
			}

			int max = 0;
			int count;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int N = 100; N > 0; N--) {
						count = 0;
						for (int r = 0; r < (N + 1) / 2; r++) {
							if (i + r < 100 && i + N - 1 - r < 100) {
								if (map[i + r][j] == map[i + N - 1 - r][j])
									count++;
							}
						}
						if (count == (N + 1) / 2)
							max = Math.max(max, N);

						count = 0;
						for (int r = 0; r < (N + 1) / 2; r++) {
							if (j + r < 100 && j + N - 1 - r < 100) {
								if (map[i][j + r] == map[i][j + N - 1 - r])
									count++;
							}
						}
						if (count == (N + 1) / 2)
							max = Math.max(max, N);
					}

				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}