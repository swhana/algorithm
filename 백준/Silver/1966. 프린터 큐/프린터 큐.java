import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int k = 1; k <= tc; k++) {
            int N = sc.nextInt();
            int idx = sc.nextInt(); //찾고싶은 문서의 현재 위치

            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> res = new LinkedList<>();
            int[] arr = new int[N];
            int[] sorted = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();  //중요도
                sorted[i] = arr[i];
            }

            Arrays.sort(sorted);

            for (int i = 0; i < N; i++)
                queue.offer(i);

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                while (arr[queue.peek()] < sorted[N - 1 - i]) {
                    queue.offer(queue.poll());
                }
                if (queue.poll() == idx) {
                    System.out.println(++cnt);
                    break;
                } else
                    cnt++;
            }
        }
    }
}