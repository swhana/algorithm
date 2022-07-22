package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_2438_별찍기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String star = "";
		String space = "";
		for(int i=1; i<=N; i++) {
			for(int j=0; j<N-i; j++) {		//N-i개의 공백
				System.out.print(" ");
			}
			star+="*";
			System.out.println(star);	
		}
		sc.close();
	}

}
