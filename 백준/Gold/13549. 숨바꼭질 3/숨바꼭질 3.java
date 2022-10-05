import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static boolean[] visited;

    static void find(int st) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(st, 0));
        visited[st] = true;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.v] = true;

            if (node.v == K) {
                System.out.println(node.cost);
                return;
            }

            //X-1
            if (node.v - 1 >= 0 && !visited[node.v - 1]) {
                pq.add(new Node(node.v - 1, node.cost + 1));
            }

            //X+1
            if (node.v + 1 < 100001 && !visited[node.v + 1]) {
                pq.add(new Node(node.v + 1, node.cost + 1));
            }

            //X*2
            //!visited[node.v*2] && node.v *2 <100001 이렇게 하면 ArrayIndexOutofBounds Exception
            if (node.v * 2 < 100001 && !visited[node.v * 2]) {
                pq.add(new Node(node.v * 2, node.cost));
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   //출발지
        K = sc.nextInt();   //목적지

        visited = new boolean[100001];

        if (N == K) {
            System.out.println(0);
            return;
        }

        find(N);
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