import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 0, 1};
    static boolean[][] visited;
    static int[][] arr;
    static LinkedList<int[]>[][] Edge;
    static int state = 1;
    static int cnt = 0;

    public static void dfs(int r, int c, int state) {
        if (r == N - 1 && c == N - 1) {
            cnt++;
            return;
        }

        boolean flag;
        if (state == 1) {
            flag = true;
            if (c + 1 < N && arr[r][c + 1] != 1) {
                dfs(r, c + 1, 1);
            }

            for (int n = 0; n < 3; n++) {
                int nr = r + dr[n];
                int nc = c + dc[n];
                if (nr >= N || nc >= N || arr[nr][nc] == 1)
                    flag = false;
            }
            if (flag == true) {
                dfs(r + 1, c + 1, 3);
            }
        }

        if (state == 2) {
            flag = true;
            if (r + 1 < N && arr[r + 1][c] != 1) {
                dfs(r + 1, c, 2);
            }

            for (int n = 0; n < 3; n++) {
                int nr = r + dr[n];
                int nc = c + dc[n];
                if (nr >= N || nc >= N || arr[nr][nc] == 1)
                    flag = false;
            }
            if (flag == true) {
                dfs(r + 1, c + 1, 3);
            }

        }

        if (state == 3) {
            flag = true;
            if (c + 1 < N && arr[r][c + 1] != 1) {
                dfs(r, c + 1, 1);
            }
            if (r + 1 < N && arr[r + 1][c] != 1) {
                dfs(r + 1, c, 2);
            }

            for (int n = 0; n < 3; n++) {
                int nr = r + dr[n];
                int nc = c + dc[n];
                if (nr >= N || nc >= N || arr[nr][nc] == 1)
                    flag = false;
            }
            if (flag == true) {
                dfs(r + 1, c + 1, 3);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        visited = new boolean[N][N];

        Edge = new LinkedList[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 1, 1);

        System.out.println(cnt);
    }
}