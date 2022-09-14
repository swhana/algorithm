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

        //알아보기 쉽도록...(1번방부터 시작)
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

            //연결된 간선 처리
            com[a].add(b);
            com[b].add(a);
        }

        //1번 컴퓨터와 연결된 모든 컴퓨터를 찾기
        dfs(1);

        //바이러스에 걸린 컴퓨터 수를 저장할 변수
        int cnt = 0;
        for (int i = 2; i < N + 1; i++) {   //1번 컴퓨터 제외
            //1번 컴퓨터와 연결되어 있다면(dfs(1)을 통해 방문한 적이 있다면)
            if (visited[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int idx) {
        visited[idx] = true;    //방문 처리
        //com[idx]의 모든 자식 노드 i 방문
        for (int i : com[idx]) {
            //방문한 적이 없다면
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}