import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] com;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //컴퓨터의 수(노드 수)
        int M = Integer.parseInt(br.readLine());    //연결된 컴퓨터 쌍의 수(간선 수)

        com = new LinkedList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            com[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            com[a].add(b);
            com[b].add(a);
        }

        dfs(1);
        int cnt = 0;
        for (int i = 2; i < N + 1; i++) {   //1번 컴퓨터 제외
            if (visited[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int idx) {
        visited[idx] = true;
        for (int i : com[idx]) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}