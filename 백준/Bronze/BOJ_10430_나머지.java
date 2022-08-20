package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_10430_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println(((A%C)+(B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C)*(B%C))%C);

	}

    public static class BOJ_2884_알람시계 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int H = sc.nextInt();
            int M = sc.nextInt();

            if(M<45) {
                if(H==0)
                    System.out.printf("%d %d", 23, M+15);
                else
                    System.out.printf("%d %d", H-1, M+15);
            }

            else
                System.out.printf("%d %d", H, M-45);
        }

    }
}
