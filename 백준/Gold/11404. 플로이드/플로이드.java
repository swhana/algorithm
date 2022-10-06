import java.util.Scanner;

public class Main {
    static final int INF = 1000000000;
    static int N, M;
    static int[][] dist;

    //v : 경유지
    private static void floyd() {
        //경유지 w
        for (int w = 1; w <= N; w++) {
            //출발지 s
            for (int s = 1; s <= N; s++) {
                //도착지 e
                for (int e = 1; e <= N; e++) {
                    if (dist[s][e] > dist[s][w] + dist[w][e])
                        dist[s][e] = dist[s][w] + dist[w][e];
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        dist = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dist[i][j] = INF;
                if (i == j) dist[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int cost = sc.nextInt();
            dist[st][ed] = Math.min(dist[st][ed], cost);    //이미 값이 들어가 있다면 더 작은 값을 넣어줘야함
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (dist[i][j] != INF)
                    sb.append(dist[i][j]).append(" ");
                else
                    sb.append(0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}