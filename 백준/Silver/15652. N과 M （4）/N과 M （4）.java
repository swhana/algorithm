/*
* 비내림차순(오름차순 + 등호 케이스)
* */

import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void perm(int start, int depth){
        //한줄 다 채우면 출력
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        //start부터 시작
        for(int i=start; i<=N; i++){
            arr[depth] = i;
            perm(i, depth+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        arr = new int[M];

        perm(1, 0);
        System.out.println(sb);
    }
}
