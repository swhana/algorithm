import java.util.Scanner;

public class Main {
    static int[][] map;
    static int w;
    static int h;
    static boolean[][] visited;
    static int cnt;

    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

    public static boolean search(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
//                    visited[nr][nc] = true;
                    return true;
                }
            }
        }
        return false;
    }


    public static void dfs(int r, int c) {
        //더이상 돌아갈 수 있는 곳이 없으면
        if (!search(r, c)) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                return;
            }
            cnt = 0;
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }


    }

}