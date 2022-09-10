import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();       //수열의 길이

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for (int i = 1; i < N; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int lo = 0;
                int hi = list.size();
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (list.get(mid) < arr[i]) {
                        lo = mid + 1;
                    } else
                        hi = mid;
                }
                list.set(lo, arr[i]);
            }
        }

        System.out.println(list.size());
    }


}