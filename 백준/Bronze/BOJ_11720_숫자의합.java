package Baekjoon.Bronze;

import java.util.Scanner;


public class BOJ_11720_숫자의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String st = sc.nextLine();

        int sum = 0;
        for(int i=0; i<N; i++)
        {
            sum += (st.charAt(i)-'0');
        }

        System.out.println(sum);
    }
}
