//원래 풀이도 방법은 맞았는데 HashMap을 Array로 바꾸니 해결되서 아쉬워서 올린 코드. HashMap이라고 무조건 빠른 것은 아닌것같다

import java.util.*;

public class Solution_BOJ_겹치는건싫어_sangwon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] count = new int[100001];
		int[] arr = new int[N];
		
		int max = Integer.MIN_VALUE;
		int lp = 0;
		int rp = 0;

		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			int cnt = count[arr[i]];
			if(cnt == K) {
				while(lp < rp) {
					count[arr[lp]]--; //연속 부분수열의 맨 왼쪽 원소부터 제외
					if(arr[lp] == arr[i]) {
						lp++;
						break;
					}
					lp++;
				}
			}
			count[arr[i]]++;
			rp++;
			if(max < rp-lp) max = rp-lp;
		}	

		System.out.println(max);
	}
}
