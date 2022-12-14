import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N + 1];
        int[] sum = new int[N + 1];
        int[][] ij = new int[M][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum[i] += sum[i - 1] + num[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ij[i][0] = Integer.parseInt(st.nextToken());
            ij[i][1] = Integer.parseInt(st.nextToken());
        }
        //////////입력부분 끝//////////
        for (int i = 0; i < M; i++) {
            bw.write(sum[ij[i][1]] - sum[ij[i][0] - 1] + "\n");
        }
        bw.close();
    }
}