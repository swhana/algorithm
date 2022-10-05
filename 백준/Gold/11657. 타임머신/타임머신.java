import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int V, E;
    static List<Node> Edge;
    static long[] dist;
    static boolean negative;

    private static void bellman_ford(int st) {
        dist[st] = 0;   //처음 방문

        //정점의 수만큼 반복
        for (int i = 1; i < N + 1; i++) {
            //매 반복마다 모든 간선 확인하기
            for (int j = 0; j < Edge.size(); j++) {
                int start = Edge.get(j).st;
                int end = Edge.get(j).ed;
                int cost = Edge.get(j).cost;

                if (dist[start] == INF) continue;

                if (dist[end] > dist[start] + cost) {
                    if (i == N) {
                        negative = true;
                        return;
                    }
                    dist[end] = dist[start] + cost;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   //도시 개수
        M = sc.nextInt();   //버스 개수

        Edge = new ArrayList<>();
        dist = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int cost = sc.nextInt();

            Edge.add(new Node(st, ed, cost));
        }

        bellman_ford(1);

        StringBuilder sb = new StringBuilder();

        if (negative) sb.append(-1);
        else {
            for (int i = 2; i < N + 1; i++) {
                if (dist[i] == INF) sb.append(-1).append("\n");
                else sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Node {
        int st;
        int ed;
        int cost;

        public Node(int st, int ed, int cost) {
            this.st = st;
            this.ed = ed;
            this.cost = cost;
        }

    }
}