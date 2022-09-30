import java.util.Scanner;

public class Main {
    static int[] p; //대표자를 저장해주는 배열
    static int[] rank;

    //x가 속한 집합의 대표자 찾기
    public static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);  //x의 대표자의 대표자의 대표자의 대표자... -> x==p[x]가 될때까지
        }
        return p[x];    //x==p[x]여도 아니어도 p[x]를 리턴하면 된다
    }

    //정점 x와 y를 연결하자
    //이 문제는 간선간의 관계는 별로 중요하지 않기 때문에 따로 처리는 안함
    public static void union(int x, int y) {
        int px = find(x);   //조상을 데려오자
        int py = find(y);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //정점의 개수
        int M = sc.nextInt();   //게임 시행 횟수 = 간선의 갯수

        p = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;   //초기화
            rank[i] = 0;
        }


        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int px = find(x);
            int py = find(y);
            //두 입력값의 부모(대표자)가 같다면
            if (px == py) {
                System.out.println(i + 1);
                return;
            }

            if (rank[px] > rank[py]) {
                p[py] = px;
            } else {
                p[px] = py;
                if (rank[px] == rank[py])
                    rank[py]++;
            }
        }
        System.out.println(0);
    }
}