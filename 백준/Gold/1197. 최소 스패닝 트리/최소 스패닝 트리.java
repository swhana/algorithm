import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] p;     //대표자(presentative) 배열
    static int[] rank;  //랭크

    static class Edge {
        int start;      //시작점
        int end;        //종착점
        int value;      //가중치

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    //x의 대표자를 찾는다
    public static int find(int x) {
        if (x == p[x])
            return x;
        else
            return p[x] = find(p[x]);
    }

    //x와 y 병합
    public static void union(int x, int y) {
        int a = p[x];
        int b = p[y];

        if (a != b) {
            p[b] = a;
        }


//        if (rank[a] > rank[b]) {
//            p[b] = a;
//        } else {
//            p[a] = b;
//            if (rank[a] == rank[b])
//                rank[b]++;
//        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();   //Vertex(정점)
        int E = sc.nextInt();   //Edge(간선)

        Edge[] edges = new Edge[E]; //Edge배열 생성
        p = new int[V + 1];
//        rank = new int[V + 1];

        //초기화
        for (int i = 1; i <= V; i++) {
            p[i] = i;
//            rank[i] = 0;
        }

        for (int i = 0; i < E; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int val = sc.nextInt();

            edges[i] = new Edge(st, ed, val);
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });

        int res = 0;
        int cnt = 0;
        for (int i = 0; i < E; i++) {
            int x = edges[i].start;
            int y = edges[i].end;

            //사이클 여부 확인
            if (find(x) == find(y)) {
                continue;
            }

            union(x, y);
            res += edges[i].value;
            cnt++;

            if (cnt == V - 1) break;
        }

        System.out.println(res);
    }


}