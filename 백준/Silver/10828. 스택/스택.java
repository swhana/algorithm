import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stk = new Stack();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            if (str.contains("push")) {
                int x = Integer.parseInt(sc.next());
                stk.push(x);
            } else if (str.contains("top")) {
                if (stk.size() == 0)
                    sb.append(-1).append("\n");
                else
                    sb.append(stk.peek()).append("\n");
            } else if (str.contains("pop")) {
                if (stk.size() == 0) {
                    sb.append(-1).append("\n");
                } else
                    sb.append(stk.pop()).append("\n");
            } else if (str.contains("size")) {
                sb.append(stk.size()).append("\n");
            } else if (str.contains("empty")) {
                if (stk.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}