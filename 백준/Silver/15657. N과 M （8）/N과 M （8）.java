import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;

    static int[] input;
    static int[] result;

    static StringBuilder sb = new StringBuilder();

    public static void perm(int start, int depth){
        if(depth == M){
            for(int val : result){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++){
            result[depth] = input[i];
            perm(i, depth+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        input = new int[N];
        result = new int[M];

        for(int i=0; i<N; i++){
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        perm(0, 0);
        System.out.println(sb);
    }
}
