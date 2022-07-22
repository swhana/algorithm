package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_11653_소인수분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=2; i<10000001; i++) {
			while(N%i==0) {
				N = N/i;
				System.out.println(i);
			}
		}

	}

}
