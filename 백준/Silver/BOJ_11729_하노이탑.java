package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729_하노이탑 {

    public static StringBuilder sb = new StringBuilder();

    static void hanoi(int N, int a, int b, int c){
        if(N==1){
            sb.append(a + " " + c).append("\n");
            return;
        }
        hanoi(N-1, a, c, b);
        sb.append(a + " " + c).append("\n");
        hanoi(N-1, b, a, c);
    }



    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)(Math.pow(2, N))-1).append("\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }
}
