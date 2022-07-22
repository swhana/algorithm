package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   //N번째 숫자 찾기

        int count = 0;  //이게 N이 될때까지 간다
        int num = 0;
        String str = String.valueOf(num);

        while (count < N) {
            num++;                                      //숫자 세기 시작
            if (String.valueOf(num).contains("666"))   //숫자 안에 666이 있다?
                count++;                                //카운트 1 증가

        }
        System.out.println(num);
    }
}
