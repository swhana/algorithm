package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2581_소수 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N - M];

		int res = 0;
		int min = 0;

		for (int i = M; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j < 10001; j++) {
				if (i % j == 0)
					cnt++;
			}
			if (cnt == 2) {
				res += i;
				if (min == 0)
					min = i;
			}
		}

		if (res == 0)
			System.out.println(-1);
		else {
			System.out.println(res);
			System.out.println(min);
		}
	}
}
