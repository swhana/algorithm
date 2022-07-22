package Baekjoon.Bronze;

public class BOJ_15596_정수N개의합 {

    //정수 N개의 합을 출력하는 함수(메소드) 구현
    static long sum(int[] a){
        long sum = 0;
        for(int i=0; i<a.length; i++){
            sum += a[i];
        }

        return sum;
    }
}
