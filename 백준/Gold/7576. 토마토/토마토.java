import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M;   //상자의 가로 칸 수
    static int N;   //상자의 세로 칸 수
    static int[][] map;
    static Queue<int[]> tomato = new LinkedList<>();

    //델타배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    //주변 모든 토마토에 대해서 수행해야 하므로 bfs
    public static void bfs() {
        while (!tomato.isEmpty()) {
            //좌표 꺼내기
            int x = tomato.peek()[0];
            int y = tomato.peek()[1];
            tomato.poll();  //좌표를 가져왔으니 큐에서 제거
            //사방탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        tomato.add(new int[]{nx, ny});
                        map[nx][ny] = map[x][y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                //출발점 찾기
                if (map[i][j] == 1)
                    tomato.add(new int[]{i, j});
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max - 1);
    }
}