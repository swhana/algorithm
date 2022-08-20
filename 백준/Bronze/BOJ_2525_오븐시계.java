package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_2525_오븐시계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();	//현재 시각(시)
		int B = sc.nextInt();	//현재 시각(분)
		int C = sc.nextInt();	//요리 시간(분)
		
		int D = A*60 + B + C;
		if(Math.floorDiv(D, 60)>=24)
			System.out.printf("%d %d", Math.floorDiv(D, 60)-24, Math.floorMod(D, 60));	//floorDiv: 몫, floorMod: 나머지
		else
			System.out.printf("%d %d", Math.floorDiv(D, 60), Math.floorMod(D, 60));
		
		sc.close();		//다 쓴 스캐너 안 닫아주면 오류남
	}

}
