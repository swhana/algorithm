package Baekjoon.Silver;

import java.util.Scanner;

public class BOJ_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 빵 무게

		int x = 0; // 5kg짜리 봉투
		int y = 0; // 3kg짜리 봉투

		switch (N % 5) {
		case 1:
			if (N >= 6) {
				x = N/5 - 1;
				y = 2;
				System.out.println(x+y);
			}
			else
				System.out.println(-1);
			break;
			
		case 2:
			if (N >= 12) {
				x = N/5 - 2;
				y = 4;
				System.out.println(x+y);
			}
			else
				System.out.println(-1);
			break;

		case 3:
			if (N >= 3) {
				x = N/5;
				y = 1;
				System.out.println(x+y);
			}
			else
				System.out.println(-1);
			break;

		case 4:
			if (N >= 9) {
				x = N/5 - 1;
				y = 3;
				System.out.println(x+y);
			}
			else
				System.out.println(-1);
			break;
		default :
			if (N >= 0) {
				x = N / 5;
				y = 0;
				System.out.println(x+y);
			}
			else
				System.out.println(-1);
			break;
		}

	}

}
