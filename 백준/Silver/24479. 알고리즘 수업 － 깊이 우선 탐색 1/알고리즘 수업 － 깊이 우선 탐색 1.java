import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<Integer>[] graph;
    static int[] visited;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //정점의 수
        int M = sc.nextInt();   //간선의 수
        int R = sc.nextInt();   //시작점 R

        graph = new LinkedList[N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        while (M-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        cnt = 1;
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        if (visited[start] != 0) return;
        visited[start] = cnt;
        for (int i : graph[start]) {
            if (visited[i] == 0) {
                cnt++;
                dfs(i);
            }
        }
    }
}