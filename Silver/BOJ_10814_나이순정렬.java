package Baekjoon.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
    //StringBuilder 배열을 이용한 정렬
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder[] p = new StringBuilder[201]; //회원의 나이(1~200)에 맞춘 배열 생성

        //회원 나이별 객체
        for (int i = 0; i < p.length; i++)
            p[i] = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            //나이에 맞춰서 정렬
            p[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder val : p)
            sb.append(val);

        System.out.println(sb);
    }
}