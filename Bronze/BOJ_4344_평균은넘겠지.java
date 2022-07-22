package Baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4344_평균은넘겠지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        double std[];

        StringTokenizer st;

        for(int j=0; j<test; j++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());

            std = new double[N];
            double avg = 0.0;
            for(int i=0; i<N; i++){
                std[i]= Double.parseDouble(st.nextToken());
                avg += std[i];      //avg += std[i]/N; 했더니 틀림(계산값 차이)
            }

            avg /= (double)N;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (std[i] > avg)
                    cnt++;
            }

            double pct = (double) cnt * 100 / N;

            System.out.printf("%.3f%%\n", pct);
        }

    }

}
