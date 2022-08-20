import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();

            Stack<Integer> card_A = new Stack<>();
            for (int j = 0; j < a; j++)
                card_A.add(sc.nextInt());
            
            Collections.sort(card_A);

            int b = sc.nextInt();
            Stack<Integer> card_B = new Stack<>();
            for (int j = 0; j < b; j++)
                card_B.add(sc.nextInt());

            Collections.sort(card_B);

            while (true) {
                int pick_A = card_A.pop();
                int pick_B = card_B.pop();

                if (pick_A > pick_B) {
                    System.out.println("A");
                    break;
                } else if (pick_A < pick_B) {
                    System.out.println("B");
                    break;
                } else {
                    if (card_A.isEmpty() && !card_B.isEmpty()) {
                        System.out.println("B");
                        break;
                    } else if (card_B.isEmpty() && !card_A.isEmpty()) {
                        System.out.println("A");
                        break;
                    } else if (card_A.isEmpty() && card_B.isEmpty()) {
                        System.out.println("D");
                        break;
                    }
                }

            }
        }
    }
}