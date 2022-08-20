package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		
		int res = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<arr.length; i++) {
			int cnt = 0;
			for(int j=1; j<1001; j++) {
				if(arr[i]%j == 0)
					cnt++;
			}
			if(cnt == 2)
				res++;
		}
		
		System.out.println(res);
	}
}
