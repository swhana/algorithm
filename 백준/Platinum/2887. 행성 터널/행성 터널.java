/*
    3차원 최소신장트리

    x좌표 순으로 정렬하면
    0번째 정점에서 가장 가까운 정점은 1번째이다
    1번째에서 가장 가까운 정점은 2번째가 되고
    2번째에서 그 다음 가장 가까운 정점은 3번째가 된다
    ... N-2번째에서 가장 가까운 정점은 N-1번째가 된다
    총 N-1개의 간선이 나오게 된다
    Edge(i, i+1, dist)
    


 */

import java.util.*;

public class Main {

    static int[] p;
    static int[] rank;

    //각 행성별 정보를 담자
    static class Star {
        int x;
        int y;
        int z;
        int idx;

        public Star(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    //i번째 별이 속한 그룹의 대표자를 찾아주세요
    public static int find(int x) {
        if (x != p[x])
            p[x] = find(p[x]);
        return p[x];
    }

    //만약 시간이 너무 오래 걸린다면 rank 사용도 검토
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] > rank[py])
            p[py] = px;
        else {
            p[px] = py;
            if (rank[px] == rank[py])
                rank[py]++;
        }

    }


    static class Edge {
        int st; //시작정점의 index
        int ed; //도착정점의 index
        int dist;    //간선의 길이

        //node[st]와 node[ed] 사이의 간선
        public Edge(int st, int ed, int dist) {
            this.st = st;
            this.ed = ed;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //행성의 개수


        p = new int[N];
        rank = new int[N];

        Star[] stars = new Star[N];

        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            stars[i] = new Star(i, x, y, z);
        }

        ArrayList<Edge> fin = new ArrayList<>();

        Arrays.sort(stars, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {
                return o1.x - o2.x;
            }
        });


        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(stars[i].x - stars[i + 1].x);       //x좌표 차이가 최단거리
            fin.add(new Edge(stars[i].idx, stars[i + 1].idx, dist));
        }

        Arrays.sort(stars, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {
                return o1.y - o2.y;
            }
        });


        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(stars[i].y - stars[i + 1].y);       //y좌표 차이가 최단거리
            fin.add(new Edge(stars[i].idx, stars[i + 1].idx, dist));
        }


        Arrays.sort(stars, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {
                return o1.z - o2.z;
            }
        });


        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(stars[i].z - stars[i + 1].z);       //z좌표 차이가 최단거리
            fin.add(new Edge(stars[i].idx, stars[i + 1].idx, dist));
        }


        Collections.sort(fin, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });

        int res = 0;
        int cnt = 0;
        for (int i = 0; i < fin.size(); i++) {
            Edge e = fin.get(i);

            int st = e.st;
            int ed = e.ed;

            if (find(st) == find(ed)) continue;

            union(st, ed);
            res += e.dist;
            cnt++;
            if (cnt == N - 1) break;
        }

        System.out.println(res);
    }
}