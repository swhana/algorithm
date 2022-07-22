package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_2438_별찍기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String star = "";
		for(int i=1; i<=N; i++) {
			star+="*";
			System.out.println(star);
		}
		
		sc.close();
	}

}
