package Baekjoon.Bronze;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2562_최댓값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		
		for(int i=0; i<9; i++) {
			if(arr[i]>max)
				max = arr[i];
		}
		
		int index=0;
		while(max != arr[index]) {
			index++;
		}
		
		System.out.println(max);
		System.out.println(index+1);
		
		sc.close();
	}

}
