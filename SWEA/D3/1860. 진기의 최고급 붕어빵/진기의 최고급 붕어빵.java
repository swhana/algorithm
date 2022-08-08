import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();  //Test case

        for(int k=1; k<=tc; k++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[] client = new int[N];

            for(int i=0; i<N; i++)
                client[i] = sc.nextInt();

            Arrays.sort(client);

            StringBuilder sb = new StringBuilder();

            sb.append("#" + k + " ");

            boolean can = true;
            for(int i=0; i<N; i++){
                if((client[i]/M)*K<i+1){
                    can = false;
                    break;
                }
            }

            if(can)
                sb.append("Possible");
            else
                sb.append("Impossible");

            System.out.println(sb);
        }
    }
}