import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String str = sc.next();
			Stack<Character> operator = new Stack();

			String res = ""; // 후위 표기식 변환 문자열

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c - '0' >= 0 && c - '0' <= 9)
					res += c;
				else {
					if (operator.isEmpty())
						operator.push(c);
					else {
						res += operator.pop();
						operator.push(c);
					}

				}
			}

			// 남은 연산자 전부
			while (!operator.isEmpty()) {
				res += operator.pop();
			}

			Stack<Integer> num = new Stack();

			for (int i = 0; i < res.length(); i++) {
				char c = res.charAt(i);

				// 숫자를 만났을 경우 스택에 push
				if (c - '0' >= 0 && c - '0' <= 9) {
					num.push(c - '0');
				}
				// +를 만났을 경우 스택의 숫자 2개를 꺼내서 더한 후 다시 스택에 저장
				else {
					int a = num.pop();
					int b = num.pop();
					num.push(a + b);
				}
			}

			System.out.println("#" + tc + " " + num.pop());

		}

	}

}