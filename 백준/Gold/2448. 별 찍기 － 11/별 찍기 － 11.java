import java.util.Scanner;

public class Main {
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    private static void star(int r, int c, int N) {
        //기저조건
        if (N == 3) {
            /*
                        *
                       * *
                      *****
                      만들기
             */
            //윗줄
            map[r][c] = '*';
            //가운데줄
            map[r + 1][c - 1] = '*';
            map[r + 1][c + 1] = '*';
            //아랫줄
            map[r + 2][c - 2] = '*';
            map[r + 2][c - 1] = '*';
            map[r + 2][c] = '*';
            map[r + 2][c + 1] = '*';
            map[r + 2][c + 2] = '*';
            return;
        }

        //유도조건
        star(r, c, N / 2);  //윗줄
        star(r + N / 2, c - N / 2, N / 2);  //아랫줄 왼쪽
        star(r + N / 2, c + N / 2, N / 2);  //아랫줄 오른쪽
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        map = new char[N][2 * N - 1];  //가로 2N-1, 세로 N
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                map[i][j] = ' ';
            }
        }

        star(0, N - 1, N);  //map[0][N-1]에서 시작

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}