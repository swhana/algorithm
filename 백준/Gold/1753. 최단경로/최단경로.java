import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static int st;
    static List<Node>[] adjList;
    static boolean[] visited;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        //cost순으로 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static void dijkstra(int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
//        visited[v] = true;    //무한루프의 원인
        dist[v] = 0;    //시작점의 거리 초기화
        pq.add(new Node(v, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            //거리가 가장가까운 인접노드부터 꺼내야하는데
            //이미 Node 자체에서 정렬을 시켜놨으므로 그냥 꺼내도 문제없음

            //curr.v가 새로운 기준 정점
            if (visited[curr.v]) continue;  //가려는 정점이 이미 방문한 곳이면 통과
            visited[curr.v] = true;

            //curr.v의 인접 노드들 탐색
            for (Node node : adjList[curr.v]) {
                if (dist[node.v] > dist[curr.v] + node.cost) {
                    dist[node.v] = dist[curr.v] + node.cost;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        st = sc.nextInt();

        visited = new boolean[V + 1];
        dist = new int[V + 1];
        adjList = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adjList[u].add(new Node(v, w));
//            adjList[v].add(new Node(u, w));       //무방향이면 이것도 쓰자
        }

        dijkstra(st);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] != INF)
                sb.append(dist[i]).append("\n");
            else
                sb.append("INF").append("\n");
        }

        System.out.println(sb);
    }
}