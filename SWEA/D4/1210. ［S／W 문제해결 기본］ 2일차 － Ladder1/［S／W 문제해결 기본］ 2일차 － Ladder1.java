import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] ladder = new int[100][100];

        for (int k = 1; k <= 10; k++) {
            int tc = sc.nextInt();

            //사다리 채우기
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = sc.nextInt();
                }
            }

            int[] dx = {0, 0, -1};
            int[] dy = {1, -1, 0};
            int n = 0;
            int x = 99;
            int y = 0;
            for (int i = 0; i < 100; i++) {
                if (ladder[99][i] == 2)
                    y = i;
            }


            while (x > 0) {
                int nx = x + dx[n];
                int ny = y + dy[n];
                if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                    if (ladder[nx][ny] == 1) {
                        x = nx;
                        y = ny;
                        ladder[nx][ny] = -1;
                    }
                }
                n = (n + 1) % 3;
            }

            System.out.println("#" + tc + " " + y);

        }
    }
}