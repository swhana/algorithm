import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static int max = 0;
    static int node;

    static void dfs(int val, int len) {
        if (len > max) {
            max = len;
            node = val;
        }

        visited[val] = true;

        for (int i = 0; i < list[val].size(); i++) {
            Node new_node = list[val].get(i);
            if (!visited[new_node.child]) {
                dfs(new_node.child, new_node.dis + len);
                visited[new_node.child] = true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());    //정점의 개수
        list = new ArrayList[V + 1];

        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); //정점 번호
            while (st.hasMoreTokens()) {
                int child = Integer.parseInt(st.nextToken());   //연결된 정점
                if (child == -1) break; //-1 입력되면 break
                int dis = Integer.parseInt(st.nextToken());
                list[num].add(new Node(child, dis));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    static class Node {
        int child;       //노드(정점) 번호
        int dis;       //정점간 거리

        public Node(int child, int dis) {
            this.child = child;
            this.dis = dis;
        }
    }
}