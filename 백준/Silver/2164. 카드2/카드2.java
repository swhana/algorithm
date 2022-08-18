import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> card = new LinkedList();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++)
			card.offer(i + 1);

		while (card.size() > 1) {
			card.poll();
			int temp = card.poll();
			card.offer(temp);
		}

		System.out.println(card.poll());
	}

}