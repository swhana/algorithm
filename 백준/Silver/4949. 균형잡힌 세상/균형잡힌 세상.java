import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            if (str.equals(".")) {
                return;
            }
            //괄호를 담을 배열
            Stack<Character> brk = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '[' || c == '(') {
                    brk.push(c);
                } else if (c == ']') {
                    if (!brk.isEmpty()) {
                        if (brk.peek() == '[') {
                            brk.pop();
                        } else {
                            brk.push(c);
                            break;
                        }
                    } else {
                        brk.push(c);
                        break;
                    }
                } else if (c == ')') {
                    if (!brk.isEmpty()) {
                        if (brk.peek() == '(') {
                            brk.pop();
                        } else {
                            brk.push(c);
                            break;
                        }
                    } else {
                        brk.push(c);
                        break;
                    }
                } else if (c == '.')
                    break;
            }
            if (brk.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");

        }
    }
}