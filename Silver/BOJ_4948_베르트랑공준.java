package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4948_베르트랑공준 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		do {
			int N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			
			
			int cnt = 0;
			boolean[] prime = new boolean[2 * N + 1];

			for (int i = 2; i < 2 * N + 1; i++) {
				if (prime[i])
					continue; // True면, 즉 소수가 아니면 스킵하고 다음i -> False면 소수란 뜻이므로 cnt+1

				if (i > N)
					cnt++;

				for (int j = i * 2; j < 2 * N + 1; j += i)
					prime[j] = true;
			}
			sb.append(cnt).append("\n");

			
		} while (true);
		System.out.println(sb);
	}
}