package Baekjoon.Bronze;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1546_평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		double[] test = new double[N];
		
		for(int i=0; i<N; i++)
			test[i] = (double)sc.nextInt();
		
		Arrays.sort(test);
		
		double M = test[N-1];

		
		double avg = 0.0;
		
		
		for(int i=0; i<N; i++) {
			test[i] = test[i]*100/M;
			avg += test[i]/N;
		}
		
		System.out.println(avg);
		

	}

}
