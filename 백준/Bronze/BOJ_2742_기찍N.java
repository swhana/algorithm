package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_2742_기찍N {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=N; i>0; i--)		//i가 0보다 큰 '동안' 반복을 계속한다는 뜻이다
			System.out.println(i);
		
		sc.close();
	}

}
