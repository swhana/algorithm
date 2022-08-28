import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); //중위표기식 입력받기

        String ans = "";    //출력할 후위표기식

        Stack<Character> stack = new Stack();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                ans += c;
            } else if (c == '(') { //여는 괄호면 일단 스택에 쌓기
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;  //괄호 내용물을 다 꺼냈으면 break
                    } else
                        ans += stack.pop(); //연산자 전부 더하기
                }
            } else if (c == '*' || c == '/') {  //우선순위가 높은 연산자는 같은 연산자가 있으면 먼저 꺼내고 푸시
                if (!stack.isEmpty()) {
                    if (stack.peek() == '*' || stack.peek() == '/')
                        ans += stack.pop();
                }
                stack.push(c);
            } else if (c == '+' || c == '-') {   //우선순위가 낮은 연산자는 높은 연산자를 먼저 꺼내야함
                if (stack.isEmpty())
                    stack.push(c);
                else if (stack.peek() == '+' || stack.peek() == '-') {
                    ans += stack.pop();
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '(') {      //괄호 시작점 올때까지 다 꺼내기
                            break;
                        } else
                            ans += stack.pop();
                    }
                    stack.push(c);
                }
            }
        }
        //남은 스택 처리
        while (!stack.isEmpty())
            ans += stack.pop();

        System.out.println(ans);
    }
}