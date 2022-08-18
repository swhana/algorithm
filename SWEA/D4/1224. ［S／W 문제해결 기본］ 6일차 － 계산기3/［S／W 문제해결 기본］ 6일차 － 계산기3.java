import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String str = sc.next();
			Stack<Character> operator = new Stack();
			Stack<Integer> num = new Stack();
			String res = "";

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c - '0' >= 0 && c - '0' <= 9) {
					res += c;
				} else if (c == '(')
					operator.push(c);
				else if (c == ')') {
					while (!operator.isEmpty()) {
						if (operator.peek() == '(') {
							operator.pop();
							break;
						} else
							res += operator.pop();
					}
				} else if (c == '*' || c == '/') {
					if (operator.peek() == '/' || operator.peek() == '*')
						res += operator.pop();
					operator.push(c);

				} else {
					if (operator.isEmpty()) {
						operator.push(c);
					} else if (operator.peek() == '-' || operator.peek() == '+') {
						res += operator.pop();
						operator.push(c);
					} else {
						while (!operator.isEmpty()) {
							if (operator.peek() == '(') {
								operator.push(c);
								break;
							} else
								res += operator.pop();
						}
					}
				}

			}

			while (!operator.isEmpty())
				res += operator.pop();

			for (int i = 0; i < res.length(); i++) {
				char c = res.charAt(i);
				if (c - '0' >= 0 && c - '0' <= 9)
					num.push(c - '0');
				else {
					int a = num.pop();
					int b = num.pop();
					if (c == '*')
						num.push(a * b);
					else if (c == '/')
						num.push(b / a);
					else if (c == '-')
						num.push(b - a);
					else
						num.push(a + b);
				}
			}

//			System.out.println(res);	//후위 표기법 출력
			System.out.println("#" + tc + " " + num.pop());

		}

	}

}