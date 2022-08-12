import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int k = 1; k <= tc; k++) {
            int N = sc.nextInt();

            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};

            int dir = 0;

            int r = 0;
            int c = 0;

            int[][] map = new int[N][N];

            for (int i = 1; i <= N * N; i++) {
                map[r][c] = i;
                r += dr[dir];
                c += dc[dir];

                if (r < 0 || c < 0 || r >= N || c >= N || map[r][c] != 0) {
                    r -= dr[dir];
                    c -= dc[dir];
                    dir = (dir + 1) % 4;
                    r += dr[dir];
                    c += dc[dir];
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(k).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}