import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        //lo <= x <= K
        long lo = 1;
        long hi = K;

        //lower bound 찾기
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;

            //x를  i로 나눈 값이 N보다 커지지 않도록
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            //x보다 작은 수
            if (K <= cnt)
                hi = mid;
            else
                lo = mid + 1;
        }
        System.out.println(lo);
    }
}