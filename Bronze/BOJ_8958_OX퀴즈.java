package Baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        String ox[] = new String[test];

        for (int i = 0; i < test; i++) {
            ox[i] = br.readLine();

            int cnt = 0;
            int sum = 0;

            for (int j = 0; j < ox[i].length(); j++) {
                    if (ox[i].charAt(j) == 'O') {
                    cnt++;
                } else
                    cnt = 0;
                sum += cnt;
            }
            System.out.println(sum);
        }
    }
}