import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, String> p; //대표자 : 무리의 리더가 누구냐?
    static HashMap<String, Integer> rank;   //친구 숫자
    static StringBuilder sb = new StringBuilder();

    //x를 입력하면 x가 속한 집합의 대표자를 반환
    public static String find(String x) {
        //x의 대표자가 x일 경우
        if (!p.get(x).equals(x))            //if(p[x] == x)
            p.put(x, find(p.get(x)));   //p[x] = find(p[x]);

        return p.get(x);                //return p[x];
    }

    public static void union(String f1, String f2) {
        String x = find(f1);    //f1이 속한 그룹의 리더 x
        String y = find(f2);    //f2가 속한 그룹의 리더 y

        //f1과 f2의 리더가 사실 같은 사람이라면? -> 건드릴게 없음
        if (x.equals(y)) {
            sb.append(rank.get(x)).append("\n");
            return;
        }

        if (rank.get(x) > rank.get(y)) {       //x의 그룹이 y보다 크면 흡수
            p.put(y, x);                       //y가 속한 그룹의 리더는 이제 x입니다
            rank.put(x, rank.get(x) + rank.get(y)); //x가 y그룹을 흡수했음
            sb.append(rank.get(x)).append("\n");
        } else {
            p.put(x, y);
            rank.put(y, rank.get(x) + rank.get(y));

            sb.append(rank.get(y)).append("\n");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int F = Integer.parseInt(br.readLine());

            p = new HashMap<>();
            rank = new HashMap<>();
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();

                //이름을 dp배열로 할 수는 없나 생각해보기
                if (!p.containsKey(f1)) {
                    p.put(f1, f1);
                    rank.put(f1, 1);    //초기 친구 숫자는 자기 포함 1명
                }
                if (!p.containsKey(f2)) {
                    p.put(f2, f2);
                    rank.put(f2, 1);    //초기 친구 숫자는 자기 포함 1명
                }


                union(f1, f2);
            }
        }
        System.out.println(sb);

    }
}