package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1427_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] arr = new int[N.length()];
        int idx = 0;

        for (int i = 0; i < N.length(); i++) {
            arr[i] = N.charAt(i) - '0';
        }

        for (int i = 0; i < N.length() - 1; i++) {
            for (int j = i + 1; j < N.length(); j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < N.length(); i++)
            System.out.print(arr[i]);
    }
}
