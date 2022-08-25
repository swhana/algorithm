import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int k = 1; k <= tc; k++) {
            int N = sc.nextInt();
            char[][] map = new char[N][N];

            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int r_count = 0;
            int c_count = 0;
            int cr_count = 0;
            int total = 0;

            row:
            for (int i = 0; i < N; i++) {
                r_count = 0;
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'o') {
                        r_count++;
                        if (r_count == 5) {
                            total++;
                            break row;
                        }
                    } else
                        r_count = 0;
                }
            }

            column:
            for (int i = 0; i < N; i++) {
                c_count = 0;
                for (int j = 0; j < N; j++) {
                    if (map[j][i] == 'o') {
                        c_count++;
                        if (c_count == 5) {
                            total++;
                            break column;
                        }
                    } else
                        c_count = 0;
                }
            }

            cross:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cr_count = 0;
                    for (int n = 0; n < N; n++) {
                        int nr = i + n;
                        int nc = j + n;
                        if (!(nr < 0 || nr >= N || nc < 0 || nc >= N)) {


                            if (map[nr][nc] == 'o') {
                                cr_count++;
                                if (cr_count == 5) {
                                    total++;
                                    break cross;
                                }
                            } else
                                cr_count = 0;
                        }
                    }
                    cr_count = 0;
                    for (int n = 0; n < N; n++) {
                        int nr = i + n;
                        int nc = j - n;
                        if (!(nr < 0 || nr >= N || nc < 0 || nc >= N)) {
                            if (map[nr][nc] == 'o') {
                                cr_count++;
                                if (cr_count == 5) {
                                    total++;
                                    break cross;
                                }
                            } else
                                cr_count = 0;
                        }
                    }


                }
            }

            if (total > 0)
                System.out.println("#" + k + " YES");
            else
                System.out.println("#" + k + " NO");

        }

    }
}