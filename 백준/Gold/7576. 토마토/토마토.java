import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M;   //상자의 가로 칸 수
    static int N;   //상자의 세로 칸 수
    static int[][] map;     //지도 배열
    static Queue<int[]> tomato = new LinkedList<>();      //BFS에 활용할 큐

    //델타배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    //주변 모든 토마토에 대해서 수행해야 하므로 BFS(DFS를 쓸 수 있는 문제인가? 싶으면 모르겠음)
    /*
        BFS의 기본적인 작성방법 : 큐를 만들어주고 -> 루트노드 큐에 입력 -> 큐에서 꺼낸 노드의 자식 노드 큐에 입력 -> 반복

        원래는 bfs(int x, int y)로 1이 입력된 좌표부터 시작하려 했으나..
        예제 중에 1이 여러개인 케이스도 발견...어?
     */
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
                    //주변에 안 익은 토마토가 있다면 (0인 값을 가지는 원소가 있다면)
                    if (map[nx][ny] == 0) {
                        tomato.add(new int[]{nx, ny});  //큐에 추가해주기
                        map[nx][ny] = map[x][y] + 1;    //이렇게 하면 visited 없이 며칠 걸렸는지 확인 가능
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
                    tomato.add(new int[]{i, j});        //1이 여러개인 케이스를 대비해 큐에 입력
            }
        }

        bfs();

        //모두 익는데 걸린 시일 구하기
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //익지 않은 토마토가 있다면 (0이 있다면)
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);     //최대값 구하기(가장 마지막에 익은 지점의 수)
            }
        }
        System.out.println(max - 1);    //시작점이 1이기 때문에 -1을 해주면 걸렸던 시일이 나온다
    }
}