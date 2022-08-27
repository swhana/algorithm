import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};


        for (int k = 1; k <= tc; k++) {
            int n = sc.nextInt();
            int d = sc.nextInt();   //d=45면 dr +1칸, d=90이면 dr+2칸

            if (d < 0) {
                d += 360;
            }


            int[][] arr = new int[n][n];
            int[][] ans = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    ans[i][j] = arr[i][j];
                }
            }


            for (int a = 0; a < 8; a++) {   //방향
                for (int b = 1; b < (n + 1) / 2; b++) { //배율
                    int nr = b * dr[a] + n / 2;
                    int nc = b * dc[a] + n / 2;

                    int nrr = b * dr[(a + (d / 45)) % 8] + n / 2;
                    int ncc = b * dc[(a + (d / 45)) % 8] + n / 2;

                    //범위 내에서
                    if (!(nrr < 0 || nrr >= n || ncc < 0 || ncc >= n) && !(nr < 0 || nr >= n || nc < 0 || nc >= n)) {
                        ans[nrr][ncc] = arr[nr][nc];
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(ans[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }
}