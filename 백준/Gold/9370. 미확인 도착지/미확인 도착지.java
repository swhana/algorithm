import java.util.*;

/*
   33% 코너케이스가 아마 최단경로가 여러가지인 경우랑
   dist의 초기화값을 Integer.MAX_VALUE로 하면 안된다고 한다

 */

public class Main {
    static final int INF = 100000000; //33%에서 오류가 나는 원인중 하나(다른 원인도 있음)
    static List<Node>[] Edge;
    static int[] goal;
    static boolean[] visited;
    static int[] dist;
    static int n;
    static StringBuilder sb = new StringBuilder();

    private static void dijkstra(int st) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[st] = 0;
        pq.add(new Node(st, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visited[curr.v]) continue;
            visited[curr.v] = true;

            for (Node node : Edge[curr.v]) {
                if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.cost) {
                    dist[node.v] = dist[curr.v] + node.cost;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();   //Test case
        for (int tc = 0; tc < T; tc++) {
            n = sc.nextInt();   //교차로
            int m = sc.nextInt();   //도로
            int t = sc.nextInt();   //목적지 후보

            int s = sc.nextInt();   //예술가들의 출발지
            int g = sc.nextInt();
            int h = sc.nextInt();

            dist = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                dist[i] = INF;
            }

            Edge = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                Edge[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();
                if ((a == g && b == h) || (a == h && b == g)) {
                    Edge[a].add(new Node(b, d * 2 - 1));
                    Edge[b].add(new Node(a, d * 2 - 1));
                } else {
                    Edge[a].add(new Node(b, d * 2));
                    Edge[b].add(new Node(a, d * 2));
                }
            }

            goal = new int[t];
            for (int i = 0; i < t; i++) {
                goal[i] = sc.nextInt();
            }

            dijkstra(s);
            Arrays.sort(goal);

            for (int i : goal) {
                if (dist[i] % 2 == 1) sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}