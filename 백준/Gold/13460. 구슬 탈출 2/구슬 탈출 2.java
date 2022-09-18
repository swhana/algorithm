import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static int[] R;
    static int[] B;
    static boolean[][][][] visited;
    static int min = Integer.MAX_VALUE;


    //델타배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void bfs(int[] R, int[] B, int count) {
        Queue<int[]> queue = new LinkedList<>();
        visited[R[0]][R[1]][B[0]][B[1]] = true;
        queue.add(new int[]{R[0], R[1], B[0], B[1], count});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cnt = cur[4];
            if (cnt >= 10) return;
            for (int i = 0; i < 4; i++) {
                int Rx = cur[0];
                int Ry = cur[1];
                int Bx = cur[2];
                int By = cur[3];

                int R_move = 0;
                int B_move = 0;

                //빨간 공 굴리기
                while (map[Rx + dx[i]][Ry + dy[i]] != '#') {
                    Rx += dx[i];
                    Ry += dy[i];
                    R_move++;
                    if (map[Rx][Ry] == 'O') break;
                }

                //파란 공 굴리기
                while (map[Bx + dx[i]][By + dy[i]] != '#') {
                    Bx += dx[i];
                    By += dy[i];
                    B_move++;
                    if (map[Bx][By] == 'O') break;
                }

                //파란 공이 구멍에 빠졌을 경우 방향 바꿔서 재탐색
                if (map[Bx][By] == 'O') continue;

                //빨간 공이 구멍에 빠졌을 경우 카운트
                if (map[Rx][Ry] == 'O') {
                    //+1 안해주면 한번에 골인하는 경우(예제5) 오답
                    min = Math.min(min, cnt + 1);
                    return;
                }

                if (Rx == Bx && Ry == By && map[Rx][Ry] != 'O') {
                    if (R_move > B_move) {
                        Rx -= dx[i];
                        Ry -= dy[i];
                    } else {
                        Bx -= dx[i];
                        By -= dy[i];
                    }
                }

                if (visited[Rx][Ry][Bx][By] == false) {
                    visited[Rx][Ry][Bx][By] = true;
                    //cnt+1이 아닌 ++cnt로 하면 예제1같은 경우 오답
                    queue.add(new int[]{Rx, Ry, Bx, By, cnt + 1});
                }
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    R = new int[]{i, j};
                }
                if (map[i][j] == 'B') {
                    B = new int[]{i, j};
                }
            }
        }

        bfs(R, B, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}