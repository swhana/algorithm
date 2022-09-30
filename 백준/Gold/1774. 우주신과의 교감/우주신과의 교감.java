import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] p;     //대표자
    static int[][] star;


    static class Edge {
        int st;     //출발점 별의 번호
        int ed;     //도착점 별의 번호
        double dist;    //두 별의 거리 = 비용

        //x번 별과 y번 별을 연결하는 간선 생성자
        public Edge(int x, int y) {
            this.st = x;
            this.ed = y;
            this.dist = Math.sqrt(Math.pow(star[x][0] - star[y][0], 2) + Math.pow(star[x][1] - star[y][1], 2)); //피타고라스 정리
        }
    }

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

        int N = sc.nextInt();   //우주신들의 개수(별로 간주)
        int M = sc.nextInt();   //통로들의 개수(이미 주어진 간선들의 개수)

        star = new int[N + 1][2];
        p = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            star[i][0] = sc.nextInt();
            star[i][1] = sc.nextInt();
            p[i] = i;
        }

        //이미 주어진 간선 = 미리 유니온파인드를 해두면 된다
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            //x와 y의 대표자가 같은지 파악할 필요는 없을듯?

            union(x, y);
        }

        //별자리만들기 그대로 가져옴
        Edge[] edges = new Edge[N * (N - 1) / 2];
        //i번째 별과 j번째 별을 엮는 간선 만들기
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
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
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i].st;
            int y = edges[i].ed;

            if (find(x) == find(y)) continue;

            union(x, y);
            res += edges[i].dist;
            cnt++;

            if (cnt == N - M - 1) break;
        }
        System.out.println(String.format("%.2f", res));
    }

}