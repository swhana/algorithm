import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        Stack<Integer> arr = new Stack<>();

        for (int i = 0; i < K; i++) {
            int n = sc.nextInt();

            if (n != 0)
                arr.push(n);
            else
                arr.pop();
        }

        int sum = 0;
        while (!arr.isEmpty()) {
            sum += arr.pop();
        }

        System.out.println(sum);
    }
}