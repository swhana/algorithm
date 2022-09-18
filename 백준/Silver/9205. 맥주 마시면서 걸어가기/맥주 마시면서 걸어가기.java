/*
    맥주 1캔에 50m, 최대 20개를 들고 있을 수 있으므로 최대 1000m
    두 지점간의 거리는 x좌표 차이 + y좌표 차이
    집, 편의점, 펜타포트를 전부 간선으로 연결하고
    1000m이내로 연결할 수 있는곳을 전부 방문
    마지막 펜타포트에 방문한 적이 있는지 확인
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static LinkedList<Integer>[] E;
    static int[][] map;
    static Queue<Integer> queue = new LinkedList<>();


    public static void bfs(LinkedList<Integer>[] E, int start) {
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int i = queue.poll();   //정점 추출
            for (int j : E[i]) {      //i의 인접점 순서대로 방문
                int x = Math.abs(map[i][0] - map[j][0]); //x좌표 거리
                int y = Math.abs(map[i][1] - map[j][1]); //y좌표 거리
                if (visited[j] == false && (x + y) <= 1000) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();   //테스트 케이스

        //테스트 케이스 구간
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();   //편의점 개수

            map = new int[n + 2][2];
            E = new LinkedList[n + 2];      //E[0]=집, E[n+1]=펜타포트
            visited = new boolean[n + 2];
            for (int i = 0; i < n + 2; i++)
                E[i] = new LinkedList<>();


            for (int i = 0; i < n + 2; i++) {
                map[i][0] = sc.nextInt();
                map[i][1] = sc.nextInt();

                for (int j = 0; j < n + 2; j++) {
                    if (i != j) E[i].add(j);
                }
            }

            bfs(E, 0);

            if (visited[n + 1] == true) {
                System.out.println("happy");
            } else
                System.out.println("sad");
        }
    }
}