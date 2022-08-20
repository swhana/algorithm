package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869_달팽이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int day = (v-b)/(a-b);  //주석과의 코드 차이가 시간초를 결정했음
        if((v-b)%(a-b)!=0)
            day++;
        
        /*
        int day = 0;
        int meter = 0;

        while(meter < v){
            day++;
            meter += a;
            if(meter>=v)
                break;
            else
                meter -= b;
        }
        */

        System.out.println(day);
    }
}
