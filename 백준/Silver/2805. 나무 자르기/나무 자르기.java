import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static long func(int[] arr, long lo, long hi) {
        while (lo <= hi) {  //lo < hi여도 안됨
            long cnt = 0;
            long mid = (lo + hi) / 2;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= mid)
                    cnt += arr[i] - mid;
            }

            if (cnt < M) {
                hi = mid - 1;
            } else {
                lo = mid + 1;   //lo = mid 여도 안됨
            }
        }
        return hi;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        long max = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            if (max < arr[i])
                max = arr[i];
        }
        System.out.println(func(arr, 0, max));
    }
}