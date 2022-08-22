import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int k = 1; k <= tc; k++) {
            String str = sc.next();
            Stack<Character> VPS = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(') {
                    VPS.push(c);
                } else if (c == ')') {
                    if (!VPS.isEmpty()) {   //스택이 남아있을 경우
                        if (VPS.peek() == '(')  // ()
                            VPS.pop();
                        else {                  // ))
                            VPS.push(c);
                            break;
                        }
                    } else {                //스택이 비어있을 경우
                        VPS.push(c);
                        break;
                    }
                }
            }
            if (VPS.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}