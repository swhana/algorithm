import java.util.Scanner;

public class Solution {
    static int D;
    static int W;
    static int K;
    static int[][] film;
    static boolean[] visited;
    static int min;
    static int[] layerA;
    static int[] layerB;

    private static void dive(int depth, int cnt) {
        //기저조건
        if (depth == D) {
            if (test()) {
                if (cnt < min) min = cnt;
            }
            return;
        }

        //min = 임시최적해
        //cnt >= min 이면 더이상 탐색할 필요없음
        if (cnt >= min) return;

        int[] temp = film[depth];
        //약품처리x
        dive(depth + 1, cnt);

        //A약품주입
//        insertion(depth, 0);
        film[depth] = layerA;
        dive(depth + 1, cnt + 1);

        //B약품주입
//        insertion(depth, 1);
        film[depth] = layerB;
        dive(depth + 1, cnt + 1);

        //행렬복원
        film[depth] = temp;
    }


    //약품주입 후 검사
    private static void insertion(int row, int att) {
        for (int c = 0; c < W; c++) {
            film[row][c] = att;
        }
    }


    //약품검사
    private static boolean test() {
        for (int c = 0; c < W; c++) {
            int cnt = 1;
            int max = 0;
            for (int r = 0; r < D - 1; r++) {
                if (film[r][c] == film[r + 1][c]) cnt++;
                else cnt = 1;
                if (cnt > max) max = cnt;
            }
            if (max < K) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //입력처리
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //Test case

        for (int tc = 1; tc <= T; tc++) {
            D = sc.nextInt();   //보호필름 두께 D
            W = sc.nextInt();   //가로크기 W
            K = sc.nextInt();   //합격기준 K

            film = new int[D][W];
            layerA = new int[W];
            layerB = new int[W];
            for (int i = 0; i < W; i++) {
                layerB[i] = 1;
            }

            for (int r = 0; r < D; r++) {
                for (int c = 0; c < W; c++) {
                    film[r][c] = sc.nextInt();
                }
            }


            visited = new boolean[D];
            min = Integer.MAX_VALUE;

            dive(0, 0);

            System.out.println("#" + tc + " " + min);
        }


    }
}