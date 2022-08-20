package Baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_10809_알파벳찾기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//각 알파벳에 대하여, 일치할 경우 해당 알파벳이 있는 '인덱스'를 출력, 일치하지 않을 경우 -1 출력
		
		//출력용 인덱스를 담을 배열
		int[] res = new int[26];
		
		String s = br.readLine();
		
		for(int i=0; i<res.length; i++)	//기본은 -1로 초기화
			res[i] = -1;
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);	//i번째 인덱스의 문자를 저장
			
			if(res[ch-97]==-1)		//'a'=97
				res[ch-97] = i;		//해당 '인덱스'를 배열에 저장
		}
		
		for(int i=0; i<res.length; i++)
			System.out.print(res[i] + " ");
		
		
	}

}
