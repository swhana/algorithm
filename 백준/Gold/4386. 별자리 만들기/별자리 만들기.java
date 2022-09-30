/*
    별 : 정점
    별자리 : 신장트리

    최소신장트리를 만드는 비용 <- 간선의 길이의 합

 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] p; //대표자
    static double[][] star;

    public static class Edge {
        int st;     //출발점 별의 번호
        int ed;     //도착점 별의 번호
        double dist;    //두 별의 거리 = 비용

        //x번 별과 y번 별을 연결하는 간선 생성자
        public Edge(int x, int y) {
            this.st = x;
            this.ed = y;
            this.dist = Math.sqrt(Math.pow(star[x][0] - star[y][0], 2) + Math.pow(star[x][1] - star[y][1], 2)); //피타고라스 정리
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "st=" + st +
                    ", ed=" + ed +
                    ", dist=" + dist +
                    '}';
        }
    }

    //i번째 별이 속한 그룹의 대표자를 찾아주세요
    public static int find(int x) {
        if (x != p[x])
            p[x] = find(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        p[py] = px;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //별의 갯수(정점의 수)

        star = new double[N][2]; //별의 좌표를 적을 배열
        p = new int[N];

        for (int i = 0; i < N; i++) {
            star[i][0] = sc.nextDouble();   //x좌표
            star[i][1] = sc.nextDouble();   //y좌표
            p[i] = i;
        }

        Edge[] edges = new Edge[N * (N - 1) / 2];
        //i번째 별과 j번째 별을 엮는 간선 만들기
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                edges[idx++] = new Edge(i, j);
            }
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.dist > o2.dist)
                    return 1;
                else if (o1.dist < o2.dist)
                    return -1;
                else
                    return 0;
            }
        });

        double res = 0.0;
        int cnt = 0;
        for (int i = 0; i < N * (N - 1) / 2; i++) {
            int st = edges[i].st;
            int ed = edges[i].ed;

            if (find(st) == find(ed)) continue;

            union(st, ed);
            res += edges[i].dist;
            cnt++;
            if (cnt == N - 1) break;
//            System.out.println(edges[i].toString());
        }
        System.out.println(String.format("%.2f", res));

    }
}