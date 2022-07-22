/*Math 메소드가 기본제공인줄 몰랐다
 * 일일이 if문으로 비교하면서 최솟값 찾는게 아니라 그냥 Math.min함수 이용하면 간단하게 풀리는 문제*/
package Baekjoon.Bronze;

import java.util.*;

public class BOJ_1085_직사각형에서탈출 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int x_min=Math.min(x, w-x);
		int y_min=Math.min(y, h-y);
		
		System.out.println(Math.min(x_min, y_min));
	}
}
