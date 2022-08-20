package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181_단어정렬 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length())
                    return s1.compareTo(s2); // 사전순 정렬
                else
                    return s1.length() - s2.length(); // 글자수 비교
            }
        });

        // 중복제거
        System.out.println(arr[0]);
        for (int j = 1; j < N; j++) {
            if (!arr[j].equals(arr[j - 1]))
                System.out.println(arr[j]);
        }

    }

}
