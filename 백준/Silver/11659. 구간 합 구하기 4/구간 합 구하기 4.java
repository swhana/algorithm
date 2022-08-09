import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] num = new int[N+1];
        int[] sum = new int[N+1];
        int[][] ij = new int[M][2];
        for(int i=1; i<=N; i++) {
            num[i] = sc.nextInt();
            sum[i] += sum[i-1] + num[i];
        }

        for(int i=0; i<M; i++) {
            ij[i][0] = sc.nextInt();
            ij[i][1] = sc.nextInt();
        }
        //////////입력부분 끝//////////

        for(int i=0; i<M; i++){
            System.out.println(sum[ij[i][1]] - sum[ij[i][0]-1]);
        }

    }
}