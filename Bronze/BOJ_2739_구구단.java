package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_2739_구구단 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1; i<10; i++)
			System.out.printf("%d * %d = %d\n", N, i, N*i);		
		
		sc.close();
	}

}
