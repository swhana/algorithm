/*
    이항계수 (n k) = n!/((n-k)!k!)

    모듈로 곱셈 역원
    n!*(n-k)!^(p-2)*k!^(p-2)와 같다

    여기서 p = 1000000007

 */


import java.util.Scanner;

public class Main {
    static int N, K;
    static final long p = 1000000007;

    static long[] factorial;

    //num ^ n 구하기
    private static long pow(long num, long n) {
        if (n == 1) return num;


        long stat = pow(num, n / 2) % p;

        if (n % 2 == 1) return (((stat * stat) % p) * num) % p;
        else return (stat * stat) % p;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        factorial = new long[N + 1];

        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            factorial[i] = (factorial[i - 1] * i) % p;
        }

//        System.out.println(Arrays.toString(factorial));
        long res = ((factorial[N] * (pow(factorial[N - K], p - 2)) % p) * (pow(factorial[K], p - 2))) % p;

        System.out.println(res);
    }
}