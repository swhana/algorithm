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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] p;
    static int[] rank;

    //각 행성별 정보를 담자(정점)
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

    //간선
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

    //Kruskal Algorithm을 위한 setting
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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt;

        int N = Integer.parseInt(br.readLine());   //행성의 개수

        //Kruskal Algorithm을 위한 준비
        p = new int[N];     //대표자를 담는 배열
        rank = new int[N];  //트리의 rank비교

        Star[] stars = new Star[N];                 //정점을 넣을 배열
        ArrayList<Edge> fin = new ArrayList<>();    //간선을 넣을 list

        //초기화 파트
        for (int i = 0; i < N; i++) {
            stt = new StringTokenizer(br.readLine());
            p[i] = i;
            rank[i] = 0;
            int x = Integer.parseInt(stt.nextToken());
            int y = Integer.parseInt(stt.nextToken());
            int z = Integer.parseInt(stt.nextToken());
            //행성번호를 따로 기록해두지 않으면 정렬할때마다 순서가 뒤죽박죽이 된다
            stars[i] = new Star(i, x, y, z);        //i: 행성번호, x, y, z : 좌표
        }

        //x좌표를 기준으로 정렬
        Arrays.sort(stars, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {
                return o1.x - o2.x;
            }
        });

        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(stars[i].x - stars[i + 1].x);           //i행성에서 가장 가까운 정점과의 x좌표 거리
            fin.add(new Edge(stars[i].idx, stars[i + 1].idx, dist));    //i행성에서 x좌표상 가장 가까운 정점과의 간선을 리스트에 입력
        }

        //y좌표를 기준으로 정렬
        Arrays.sort(stars, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {
                return o1.y - o2.y;
            }
        });

        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(stars[i].y - stars[i + 1].y);           //i행성에서 가장 가까운 정점과의 y좌표 거리
            fin.add(new Edge(stars[i].idx, stars[i + 1].idx, dist));    //i행성에서 y좌표상 가장 가까운 정점과의 간선을 리스트에 입력
        }

        //z좌표를 기준으로 정렬
        Arrays.sort(stars, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {
                return o1.z - o2.z;
            }
        });


        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(stars[i].z - stars[i + 1].z);            //i행성에서 가장 가까운 정점과의 z좌표 거리
            fin.add(new Edge(stars[i].idx, stars[i + 1].idx, dist));     //i행성에서 z좌표상 가장 가까운 정점과의 간선을 리스트에 입력
        }

        //총 3(N-1)개의 간선이 리스트에 들어갔고, 이걸 다시 dist(거리)순으로 정렬
        Collections.sort(fin, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });

        int res = 0;        //결과값을 담을 변수
        int cnt = 0;        //시행횟수
        for (int i = 0; i < fin.size(); i++) {
            Edge e = fin.get(i);    //가장 작은 dist를 가진 간선부터 추출

            int st = e.st;
            int ed = e.ed;

            if (find(st) == find(ed)) continue; //이미 한번 시행한 간선일 경우 더이상 처리하지 않음(예: 이미 x좌표로 최단거리를 구했으면 y좌표나 z좌표는 무시)

            union(st, ed);
            res += e.dist;              //최단거리를 결과값에 더해줌
            cnt++;
            if (cnt == N - 1) break;    //N개의 정점에 대해 N-1개의 간선을 얻으면 거기서 MST완성
        }

        System.out.println(res);
    }
}