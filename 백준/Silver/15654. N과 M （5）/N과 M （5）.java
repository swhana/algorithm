import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] input;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void perm(int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = input[i];
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        input = new int[N];
        arr = new int[M];
        visited = new boolean[N+1];
        for(int i=0; i<N; i++){
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        perm(0);
        System.out.println(sb);
    }
}
