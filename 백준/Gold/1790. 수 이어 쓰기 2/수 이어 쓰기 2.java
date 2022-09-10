import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //입력값의 배열길이를 반환하는 함수
    static long len(int N) {
        long total = 0;
        int digit = 1;
        for (int i = 1; i <= N; i *= 10) {
            int max = i * 10 - 1;   //i랑 같은 자릿수의 최대값
            if (max > N) {           //N의 자릿수에 도달했을 경우
                max = N;
            }
            total += (max - i + 1) * digit;
            digit++;
        }
        return total;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int lo = 1;
        int hi = N;


        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (len(mid) >= K)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        if (lo > N) {
            System.out.println(-1);
            return;
        }

        String str = Integer.toString(lo);
        System.out.println(str.charAt((int) (K - len(hi) - 1)));
    }
}