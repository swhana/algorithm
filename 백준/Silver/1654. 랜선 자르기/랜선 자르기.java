import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int N;

    static long func(int[] arr, long lo, long hi) {
        while (lo <= hi) {  //lo < hi여도 안됨
            long cnt = 0;
            long mid = (lo + hi) / 2;

            for (int i = 0; i < arr.length; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < N) {
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

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        for (int i = 0; i < K; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        System.out.println(func(arr, 1, arr[K - 1]));   //arr[0]이 아니라 arr[K-1]을 넣었더니 통과됐다
    }
}