import java.util.*;

public class Main {
	static int cnt = 0;

	static void isConvertable(String input, String output) {
		if (cnt > 0) return;
		if (input.length() >= output.length()) {
			if (input.equals(output)) cnt++;
			return;
		}
		
		// 1번 연산
		String newA = input + 'A';

		// 2번 연산
		String newB = "";
		for (int i = 0; i < input.length(); i++) {
			newB += input.charAt(input.length() - 1 - i);
		}

		if(!output.contains(input) && !output.contains(newB)) return;
		isConvertable(newA, output);
		isConvertable('B' + newB, output);

		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.nextLine();
		String T = sc.nextLine();

		isConvertable(S, T);
		System.out.println(cnt > 0 ? 1 : 0);
	}

}
