import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            String str = sc.next();
            Stack<Character> small = new Stack<>();
            Stack<Character> medium = new Stack<>();
            Stack<Character> large = new Stack<>();
            Stack<Character> rec = new Stack<>();

            for (int i = 0; i < N; i++) {
                char c = str.charAt(i);
                if (c == '(')
                    small.push(c);
                else if (c == ')') {
                    if (!small.isEmpty()) {
                        if (small.peek() == '(')
                            small.pop();
                        else {
                            System.out.println("#" + tc + " " + 0);
                            break;
                        }
                    } else {
                        System.out.println("#" + tc + " " + 0);
                        break;
                    }
                } else if (c == '{')
                    medium.push(c);
                else if (c == '}') {
                    if (!medium.isEmpty()) {
                        if (medium.peek() == '{')
                            medium.pop();
                        else {
                            System.out.println("#" + tc + " " + 0);
                            break;
                        }
                    } else {
                        System.out.println("#" + tc + " " + 0);
                        break;
                    }
                } else if (c == '[')
                    large.push(c);
                else if (c == ']') {
                    if (!large.isEmpty()) {
                        if (large.peek() == '[')
                            large.pop();
                        else {
                            System.out.println("#" + tc + " " + 0);
                            break;
                        }
                    } else {
                        System.out.println("#" + tc + " " + 0);
                        break;
                    }
                } else if (c == '<')
                    rec.push(c);
                else if (c == '>') {
                    if (!rec.isEmpty()) {
                        if (rec.peek() == '<')
                            rec.pop();
                        else {
                            System.out.println("#" + tc + " " + 0);
                            break;
                        }
                    } else {
                        System.out.println("#" + tc + " " + 0);
                        break;
                    }
                }
            }
            if (small.isEmpty() && medium.isEmpty() && large.isEmpty() && rec.isEmpty())
                System.out.println("#" + tc + " " + 1);
        }
    }
}