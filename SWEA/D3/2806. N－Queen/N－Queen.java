/*
    boolean형으로 체크

    depth : 현재 행의 위치
    i : 퀸을 놓을 열의 위치


 */


import java.util.Scanner;

public class Solution {
    static int[] queen;   //queen[행] = 열 이런식으로 저장하면 2차원배열이 아니어도 괜찮다
    static int N;
    static int cnt; //가짓수 세기

    private static void dfs(int depth) {
        //마지막 열까지 다 놓았을 경우
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            boolean flag = false;
            //i번째 열에 퀸을 놓고싶다
            //이전 행들을 탐색
            for (int j = 0; j < depth; j++) {
                int diff = depth - j;   //현재 행과 거리차이
                if (queen[j] == i || queen[j] == i - diff || queen[j] == i + diff) {    //뭐 하나라도 걸리면 나가
                    flag = true;
                    break;
                }
            }

            //하나도 걸리는게 없었다면
            if (!flag) {
                queen[depth] = i;   //퀸 놓기
                dfs(depth + 1);     //다음 열로 넘어가기
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            queen = new int[N];
            cnt = 0;

            dfs(0);

            System.out.println("#" + tc + " " + cnt);
        }

    }
}