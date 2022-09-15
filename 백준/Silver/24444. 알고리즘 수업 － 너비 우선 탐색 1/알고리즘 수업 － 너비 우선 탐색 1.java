import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    static int N;
    static int M;
    static int R;
    static Queue<Integer> queue = new LinkedList<>();

    static LinkedList<Integer>[] E; //간선 집합
    static int[] visited;
    static int cnt = 1;


    public static void bfs(LinkedList<Integer>[] E, int R) {
        visited[R] = cnt++;  //시작점 방문처리
        queue.add(R);   //큐에 시작점 추가
        while (!queue.isEmpty()) {
            int u = queue.poll();   //정점 추출
            for (int v : E[u]) {      //정점 u의 모든 인접정점 v에 대하여
                if (visited[v] == 0) {
                    visited[v] = cnt++;
                    queue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   //정점의 수
        M = sc.nextInt();   //간선의 수
        R = sc.nextInt();   //시작점 R

        E = new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            E[i] = new LinkedList<>();
        }
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            E[a].add(b);    //간선 추가
            E[b].add(a);    //반대편도 똑같이
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(E[i]); //간선 오름차순으로 정리
        }

        bfs(E, R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }
}