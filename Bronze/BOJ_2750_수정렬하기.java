package Baekjoon.Bronze;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750_수정렬하기 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int N = stdIn.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = stdIn.nextInt();

        //dual-pivot Quicksort Algorithm : O(NlogN)~O(N^2)
        Arrays.sort(arr);

        //Selection sort : O(N^2)
//        for(int i=0; i<N-1; i++){
//            for(int j=i+1; j<N; j++){
//                if(arr[i]>arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }



        for(int i=0; i<N; i++)
            System.out.println(arr[i]);
    }
}
