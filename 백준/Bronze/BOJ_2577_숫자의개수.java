package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_2577_숫자의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		String num = String.valueOf(A*B*C);
		
		char[] digit = num.toCharArray();
		int[] cnt = new int[10];
		
		for(int i=0; i<digit.length; i++) {
			if(digit[i] == '0')
				cnt[0]++;
			else if(digit[i] == '1')
				cnt[1]++;
			else if(digit[i] == '2')
				cnt[2]++;
			else if(digit[i] == '3')
				cnt[3]++;
			else if(digit[i] == '4')
				cnt[4]++;
			else if(digit[i] == '5')
				cnt[5]++;
			else if(digit[i] == '6')
				cnt[6]++;
			else if(digit[i] == '7')
				cnt[7]++;
			else if(digit[i] == '8')
				cnt[8]++;
			else
				cnt[9]++;
		}
		
		for(int i=0; i<10; i++)
			System.out.println(cnt[i]);

	}

}
