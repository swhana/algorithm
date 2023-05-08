import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		int cntZero = 0;
		int cntOne = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '0')
				cntZero++;
			else
				cntOne++;
		}

		int startZero = input.length() - 1;
		int dcntZero = cntZero / 2;
		
		String[] arr = input.split("");
		
		//맨 오른쪽 끝부터 0을 절반 지워나간다.
		while(dcntZero > 0) {
			if(arr[startZero].equals("0")) {
				dcntZero--;
				arr[startZero] = "";
			}
			startZero--;
		}
		
		int startOne = 0;
		int dcntOne = cntOne / 2;
		
		//맨 왼쪽 끝부터 1을 절반 지워나간다.
		while(dcntOne > 0) {
			if(arr[startOne].equals("1")) {
				dcntOne--;
				arr[startOne] = "";
			}
			startOne++;
		}
		
		//이렇게 하면 사전순으로 정렬된 문자열이 생성된다.
		StringBuilder sb = new StringBuilder();
		for(String s : arr) sb.append(s);
		
		System.out.println(sb);
	}
}
