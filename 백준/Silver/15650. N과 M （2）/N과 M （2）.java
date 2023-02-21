import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();
    public static void perm(int depth){
        //한 줄이 다 채워졌을 때
        if(depth == M){
            boolean check = true;
            //배열 내용을 전부 출력
            for(int i=1; i<M; i++){
                if(arr[i]<arr[i-1]) check = false;
            }
            if(check) {
                for(int val : arr){
                    sb.append(val).append(' ');
                }
                sb.append("\n");
            }
            return;
        }

        //1부터 N까지 순회
        for(int i=1; i<=N; i++){
            //중복 피하기
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M]; //M 길이만큼의 줄 생성
        visited = new boolean[N+1];

        perm(0);

        System.out.print(sb);
    }
}
