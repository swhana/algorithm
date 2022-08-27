import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static int n, m;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 0 && m == 0) break;

            int ans = 0;    //트리의 개수
            tree = new ArrayList[n];    //ArrayList배열
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                tree[a].add(b); //a -> b 연결
                tree[b].add(a); //b -> a 연결
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) { //1번노드부터 n번노드까지 순차적으로 방문
                    visited[i] = true;
                    if (dfs(-1, i)) ans++;
                }
            }

            sb.append("Case ").append(tc).append(": ");
            if (ans == 0) {
                sb.append("No trees.\n");
            } else if (ans == 1) {
                sb.append("There is one tree.\n");
            } else
                sb.append("A forest of ").append(ans).append(" trees.\n");

            tc++;
        }
        System.out.println(sb);
    }

    public static boolean dfs(int root, int num) {
        for (int i : tree[num]) {   //tree[num]이 가진 원소들 조사
            if (i == root) continue;
            if (visited[i]) return false;    //방문한 적이 있으면 false 리턴하고 종료
            visited[i] = true;
            if (!dfs(num, i)) return false;
        }
        return true;
    }


}