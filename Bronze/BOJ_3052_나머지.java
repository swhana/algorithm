package Baekjoon.Bronze;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_3052_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[10];
		
		for(int i=0; i<10; i++)
			num[i] = sc.nextInt()%42;
		
			
		Arrays.sort(num);
		

		int cnt = 1;	
		
		for(int i=0; i<9; i++) {
			if(num[i] != num[i+1]) {
				cnt++;
			}
		}
		
		
		System.out.println(cnt);
	}
}
