import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.offer(sc.nextInt());
        }

        for (int i = 0; i < N * N - N; i++) {
            queue.offer(sc.nextInt());
            queue.poll();
        }

        System.out.println(queue.poll());
    }
}