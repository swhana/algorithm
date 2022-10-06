import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static boolean visited[];
    static int N;

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

    private static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N + 1];
        visited[N] = true;
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            visited[curr.v] = true;

            if (curr.v == 1) {
                System.out.println(curr.cost);
                return;
            }

            if (curr.v % 3 == 0 && !visited[curr.v / 3]) {
                visited[curr.v / 3] = true;
                pq.add(new Node(curr.v / 3, curr.cost + 1));
            }

            if (curr.v % 2 == 0 && !visited[curr.v / 2]) {
                visited[curr.v / 2] = true;
                pq.add(new Node(curr.v / 2, curr.cost + 1));
            }

            if (curr.v - 1 >= 1 && !visited[curr.v - 1]) {
                visited[curr.v - 1] = true;
                pq.add(new Node(curr.v - 1, curr.cost + 1));
            }

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        bfs();
    }
}