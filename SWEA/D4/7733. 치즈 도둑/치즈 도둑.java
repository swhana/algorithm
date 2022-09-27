import java.util.Scanner;

public class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void dfs(int r, int c, int day) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (!visited[nr][nc] && map[nr][nc] > day) {
                    visited[nr][nc] = true;
                    dfs(nr, nc, day);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;
            for (int d = 0; d <= 100; d++) {
                int cnt = 0;
                visited = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j] && map[i][j] > d) {
                            dfs(i, j, d);
                            cnt++;
                        }
                    }
                }
                if (cnt > max)
                    max = cnt;
            }

            System.out.println("#" + tc + " " + max);
        }

    }
}