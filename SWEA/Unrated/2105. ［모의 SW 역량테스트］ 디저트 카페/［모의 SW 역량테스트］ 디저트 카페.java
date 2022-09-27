import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};

    static int N;
    static int[][] map;
    static int max; //카운트의 최대값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
            max = -1;

            //DFS 탐색
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    //dfs(r, c);
                    //주어진 정점에서 다음 정점으로 가기위해 필요한 정보들
                    //현재 위치 (r, c), 현재 방향 d(0으로 시작, 3까지)
                    tour(r, c, r, c, 0, 0, new ArrayList<Integer>());
                }
            }

            System.out.println("#" + tc + " " + max);
        }

    }

    //DFS
    public static void tour(int or, int oc, int cr, int cc, int d, int cnt, ArrayList<Integer> list) {
        //기저조건
        //출발점(or, oc)에 도달하고,
        //우상 방향으로 도착해야(d==3)
        if (or == cr && oc == cc && d == 3) {
            if (cnt > max)
                max = cnt;
            return;
        }

        //유도조건
        //1. 기존 방향으로 그대로 가기(d => d)
        //2. 다음 방향으로 꺾어서 가기(d => d+1)

        //1.
        int nr = cr + dr[d];
        int nc = cc + dc[d];
        //경계조건
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            if (!list.contains(map[nr][nc])) { //기존에 가지 않은 디저트 카페 번호인 경우만
                list.add(map[nr][nc]);
                tour(or, oc, nr, nc, d, cnt + 1, list);
                list.remove(list.size() - 1);   //영향을 주지 않기 위해 초기화
            }
        }

        //2.
        if (d < 3) {
            nr = cr + dr[d + 1];
            nc = cc + dc[d + 1];
            //경계조건
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (!list.contains(map[nr][nc])) { //기존에 가지 않은 디저트 카페 번호인 경우만
                    list.add(map[nr][nc]);
                    tour(or, oc, nr, nc, d + 1, cnt + 1, list);
                    list.remove(list.size() - 1);   //영향을 주지 않기 위해 초기화
                }
            }
        }

    }
}