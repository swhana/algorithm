package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_10872_팩토리얼 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int N = stdIn.nextInt();

        System.out.println(factorial(N));
    }

    public static int factorial(int i) {
        if(i<=1)        //종료 조건을 넣어주지 않으면 StackOverFlow!
            return 1;
        else
            return i * factorial(i-1);

    }
}
