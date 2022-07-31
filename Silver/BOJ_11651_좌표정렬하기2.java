package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11651_좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        //Comparator 인터페이스의 compare()메소드 재정의
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                /* compare() 메소드의 리턴값
                    양수일 경우 : arr1과 arr2 순서 교체(정렬)
                    0 또는 음수일 경우 : 유지
                */
                if (arr1[1] == arr2[1])
                    return arr1[0] - arr2[0];
                else
                    return arr1[1] - arr2[1];
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        System.out.println(sb);
    }
}