import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //Lower Bound 찾기
    static int lo_bound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        //같아지는 순간 종료
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key <= arr[mid])    //FFF'T'TTTFFFF < 이게 Lower Bound
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    //Upper bound 찾기
    static int up_bound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key < arr[mid])     //FFFTTTT'F'FFF < 이게 Upper Bound
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);   //이분탐색을 위해서는 정렬이 필수

        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();

            int lo = lo_bound(arr, key);
            int hi = up_bound(arr, key);

            sb.append(hi - lo + " ");
        }
        System.out.println(sb);
    }
}