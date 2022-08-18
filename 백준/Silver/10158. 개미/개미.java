import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt(); // 격자의 가로길이
		int h = sc.nextInt(); // 격자의 세로길이

		int p = sc.nextInt(); // 개미의 초기 가로좌표
		int q = sc.nextInt(); // 개미의 초기 세로좌표

		int t = sc.nextInt(); // 시간 t

		// t초 뒤의 개미의 좌표는 (p+t, q+t)이며,
		// w, h로 나눈 나머지(np, nq) = 좌표값
		// w, h로 나눈 몫 = 경계면을 만난 횟수(cntp, cntq) -> 짝수 : 좌표 그대로, 홀수 : 좌표 반전

		int np = (p + t) % w; //
		int nq = (q + t) % h;
		int cntp = (p + t) / w;
		int cntq = (q + t) / h;

		if (cntp % 2 == 1)
			np = w - np;

		if (cntq % 2 == 1)
			nq = h - nq;

		System.out.println(np + " " + nq);

	}

}