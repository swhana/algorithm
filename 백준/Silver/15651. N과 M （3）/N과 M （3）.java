/*
*         1 2 3 4 와 같은 수열이 있다면,
*  depth= 0 1 2 3 이라고 생각하면 편함
*  자릿수를 늘려가면서 순회
*
* */

import java.util.Scanner;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void perm(int depth){
        if(depth == M){
            for(int val: arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            arr[depth] = i;
            perm(depth+1); //같은 줄 다음 수로 넘어가기
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        arr = new int[M];

        perm(0);
        System.out.println(sb);
    }
}
