import java.util.Scanner;

public class Solution {
    static int[][] arr;
    static boolean[] selected;  //선택된 재료는 true, 아닌 재료는 false
    static int n;   //nCr(n개 중에서 r개 뽑는 조합 생각하기)
    static int r;
    static int min; //최소값을 갱신할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            arr = new int[n][n];
            selected = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            //조합
            r = n / 2;
            min = Integer.MAX_VALUE;


            //n개에서 r개 뽑는 조합
            //comb(int idx, int startIdx)
            //2개를 뽑는 조합이라면 idx : 0, 1
            //3개를 뽑는 조합이라면 idx : 0, 1, 2
            //startIdx : 어디서부터 뽑을 지 정해주는 인자
            comb(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }


    private static void comb(int idx, int startIdx) {
        //기저조건
        if (idx == r) {
            int sumA = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (selected[i] && selected[j])
                        sumA += arr[i][j];
                }
            }

            int sumB = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!selected[i] && !selected[j])
                        sumB += arr[i][j];
                }
            }
            int diff = Math.abs(sumA - sumB);
            if (diff < min) min = diff;

            return;
        }

        //유도조건
        for (int i = startIdx; i < n; i++) {
            selected[i] = true;
            comb(idx + 1, i + 1);
            selected[i] = false;
        }
    }
}