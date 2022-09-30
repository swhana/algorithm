import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //정점의 개수
        int M = Integer.parseInt(st.nextToken());  //게임 시행 횟수 = 간선의 갯수

        //배열 초기화
        p = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //여기서 부터는 Union처리
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