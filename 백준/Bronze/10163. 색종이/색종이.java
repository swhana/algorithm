import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] paper = new int[1001][1001];

        for (int i = 1; i <= N; i++) {
            int colorx = sc.nextInt();   //가로 시작점 좌표
            int colory = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            //1번 색종이면 1번을 칠하게, 2번 색종이면 2번으로 덧칠하기
            for (int r = colorx; r < colorx + x; r++) {
                for (int c = colory; c < colory + y; c++) {
                    paper[r][c] = i;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int r = 0; r < 1001; r++) {
                for (int c = 0; c < 1001; c++) {
                    if (paper[r][c] == i)   //숫자만 세면 끝
                        count++;
                }
            }
            System.out.println(count);
        }
    }
}