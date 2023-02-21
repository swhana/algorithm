/*
* 1부터 N까지 중에서 M개 무작위로 고르기(중복x)
* 1~N까지 도는 i 1개(시작점)
* i+1부터 N까지 도는 j 한개
* ...
* M개면?
* 재귀형식으로 M번 돌게 해야함
* function(int M) 식으로
* */


import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] visited; //중복처리
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void perm(int depth){
        if(depth == M) {
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                perm(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        arr = new int[M];

        perm(0);

        System.out.print(sb);
    }

}
