import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int[] res;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //정점의 수
        int M = sc.nextInt();   //간선의 수
        int R = sc.nextInt();   //시작점 R

        graph = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        res = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        while (M-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        visited[R] = true;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < res.length; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        res[start] = ++cnt;
        for (int i : graph[start]) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}