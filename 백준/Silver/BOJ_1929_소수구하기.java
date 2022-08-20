package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		boolean[] prime = new boolean[N+1];		//소수인지 아닌지 판별할 boolean 배열(0과 1)
		
		for(int i=2; i<=N; i++) {
			if(prime[i]) continue;	//소수가 아니면 넘어감
			
			if(i >= M) sb.append(i).append("\n");	//i가 M이상 N이하면 소수로 체크(가장 작은 i이기 때문에)
			
			for(int j = i+i; j<=N; j+=i)	//i의 배수를 체크해서 미리 true로 만듬
				prime[j] = true;
		}
		
		System.out.println(sb);
	}
}
