package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065_한수 {

    static int han(int n){
        int cnt = 0; //한수 개수

        int a = 0;
        int b = 0;
        int c = 0;

        if(n < 100)
            cnt = n;

        else {
            cnt = 99;   //1~99까지는 전부 한수이기 때문
            for(int i=100; i<=n; i++) {
                a = i % 10;       //1의 자리
                b = (i / 10) % 10;  //10의 자리
                c = i / 100;      //100의 자리

                if ((a - b) == (b - c))
                    cnt++;
            }
        }


        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(han(N));
    }
}
