import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int R = sc.nextInt();
        int K = sc.nextInt();

        int[][] map = new int[C + 1][R + 1];
        int[] dc = {0, 1, 0, -1};
        int[] dr = {1, 0, -1, 0};
        int dist = 0;
        int c = 1;
        int r = 1;
        for (int i = 1; i <= C * R; i++) {
            map[c][r] = i;
            c += dc[dist];
            r += dr[dist];
            if (c <= 0 || r <= 0 || c > C || r > R || map[c][r] != 0) {
                c -= dc[dist];
                r -= dr[dist];
                dist = (dist + 1) % 4;
                c += dc[dist];
                r += dr[dist];
            }
        }

        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {
                if (K > C * R) {
                    System.out.println(0);
                    return;
                }
                if (map[i][j] == K)
                    System.out.println(i + " " + j);

            }
        }

    }
}