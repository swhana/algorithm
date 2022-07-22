package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020_골드바흐의추측 {

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int k=1; k<=test_case; k++) {
			int n = Integer.parseInt(br.readLine());
			
			boolean[] prime = new boolean[n+1];
			
			//소수 생성
			for(int i=2; i<n+1; i++) {
				if(prime[i]) continue;
				
				for(int j=i+i; j<n+1; j+=i)
					prime[j] = true;
			}
			int res1 = 0;
			int res2 = 0;
			int diff = 10000;
			int cnt = 0;
			for(int i=2; i<n+1; i++) {
				if(!prime[i]) {	//i가 소수이면
					if(!prime[n-i]) {	//n/i도 소수인지 판별
						if(Math.abs(i*2-n)<diff)	{//두 수의 차가 최소값이면 저장
							diff = Math.abs(i*2-n);
							res1 = i;
							res2 = n-i;
							cnt++;
						}
					}
					else
						continue;
				}
			}
			
			System.out.println(res1 + " " + res2);
		}
		
		
	}

}
