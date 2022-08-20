package Baekjoon.Silver;

import java.util.Scanner;

public class BOJ_2751_수정렬하기2 {
    public static int[] sorted;

    public static void mergeSort(int[] arr) {
        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        sorted = null;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) return;

        int i;
        int j = 0;
        int k = left;
        int idx = 0;
        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        //왼쪽 절반을 분리
        for (i = left; i <= mid; i++)
            sorted[idx++] = arr[i];

        //왼쪽절반 배열과 오른쪽절반 배열을 크기비교
        while (i <= right && j < idx)
            arr[k++] = (sorted[j] <= arr[i]) ? sorted[j++] : arr[i++];

        //sorted 배열에 남은 요소 병합
        //arr에 다시 합치기 때문에 i>right에 대해서는 검토할 필요 없음
        while (j < idx)
            arr[k++] = sorted[j++];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();   //입력받을 수의 개수 N
        int[] arr = new int[N]; //입력받을 수를 정렬할 배열

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        mergeSort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            sb.append(arr[i]).append("\n");

        System.out.println(sb);

    }
}