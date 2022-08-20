package Baekjoon.Bronze;

import java.util.Scanner;

public class BOJ_10870_피보나치수5 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();

        System.out.println(Fibonacci(n));

    }

    static int Fibonacci(int input) {
        if (input == 1)
            return 1;
        else if (input == 0)
            return 0;
        else
            return Fibonacci(input - 1) + Fibonacci(input - 2);
    }
}
