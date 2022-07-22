package Baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10818_최소최대 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer.parseInt(br.readLine());		//첫째 줄은 입력만 받고 안씀

		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 입력받은 문자열을 공백을 기준으로 잘라주는 tokenizer
		
		int max = -1000001;		//왜 이렇게 했냐면 어떤 수가 나오든 무조건 max보다는 클 것이기 때문
		int min = 1000001;		//같은 원리
		
		while(st.hasMoreTokens()) {	//토큰이 있는 한 계속해서 반복
			int res = Integer.parseInt(st.nextToken()); 	//입력받은 토큰을 정수형으로 변환해서 할당
			
			if(res>max)
				max = res;
			
			if(res<min)
				min = res;
		}
		
		System.out.print(min+" "+max);
	}
}

