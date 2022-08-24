import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<String> stk = new Stack<>(); //+랑- 담을 출력스택

        int count = 0;  //+개수 기입

        for (int i = 0; i < N; i++) {
            if (arr[i] > count) {
                while (arr[i] > count) {
                    stk.push("+");
                    count++;
                }
            }
            stk.push("-");
        }

        Stack<String> stk2 = new Stack<>();

        Stack<Integer> check = new Stack<>();
        while (!stk.isEmpty()) {
            String str = stk.pop();
            stk2.push(str);
        }

        int cnt = 0;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (!stk2.isEmpty()) {
            String temp = stk2.pop();
            sb.append(temp).append("\n");
            if (temp == "+") {
                check.push(++cnt);
            } else if (temp == "-") {
                if (check.pop() == arr[idx])
                    idx++;
                else {
                    System.out.println("NO");
                    return;
                }
            }

        }


        System.out.println(sb);

    }
}