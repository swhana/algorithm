package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11651_좌표정렬하기2 {
    //병합정렬(Merge Sort)
    public static int[][] sorted;

    public static void mergeSort(int[][] arr) {
        sorted = new int[arr.length][2];
        mergeSort(arr, 0, arr.length - 1);
        sorted = null;
    }

    //Top-down방식
    public static void mergeSort(int[][] arr, int left, int right) {
        if (left == right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        int l = left;       //반으로 나눴을 때 왼쪽 시작점
        int r = mid + 1;    //오른쪽 시작점
        int idx = left;     //새 배열의 인덱스

        //l : left~mid, r : mid+1~right 범위
        while (l <= mid && r <= right) {
            //양쪽 배열에서 차례로 비교하면서 더 작은 수를 새 배열에 입력
            if (arr[l][1] < arr[r][1]) {   //y좌표 먼저 비교
                sorted[idx][0] = arr[l][0];
                sorted[idx][1] = arr[l][1];
                idx++;
                l++;
            } else if (arr[l][1] == arr[r][1]) {  //y좌표가 같으면 x좌표 비교
                if (arr[l][0] < arr[r][0]) {
                    sorted[idx][0] = arr[l][0];
                    sorted[idx][1] = arr[l][1];
                    idx++;
                    l++;
                } else {
                    sorted[idx][0] = arr[r][0];
                    sorted[idx][1] = arr[r][1];
                    idx++;
                    r++;
                }
            } else {
                sorted[idx][0] = arr[r][0];
                sorted[idx][1] = arr[r][1];
                idx++;
                r++;
            }
        }

        //왼쪽 배열이 먼저 떨어졌을 경우
        if (l > mid) {
            while (r <= right) {
                sorted[idx][0] = arr[r][0];
                sorted[idx][1] = arr[r][1];
                idx++;
                r++;
            }
        }

        //오른쪽이 먼저 떨어졌을 경우
        if (r > right) {
            while (l <= mid) {
                sorted[idx][0] = arr[l][0];
                sorted[idx][1] = arr[l][1];
                idx++;
                l++;
            }
        }

        //합친 새 배열을 기존 배열에 대입
        for (int i = left; i <= right; i++) {
            arr[i][0] = sorted[i][0];
            arr[i][1] = sorted[i][1];
        }
    }

    //구현부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[][] arr = new int[N][2];

        for (int x = 0; x < N; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[x][0] = Integer.parseInt(st.nextToken());
            arr[x][1] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        System.out.println(sb);
    }
}