import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] colored = new int[N][2];

        for (int i = 0; i < N; i++) {
            colored[i][0] = sc.nextInt();   //색종이 x좌표 시작위치
            colored[i][1] = sc.nextInt();   //색종이 y좌표 시작위치
        }

        int[][] paper = new int[101][101];

        //전체 칸 색칠
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 101; j++) {
                if (j >= colored[i][0] && j < colored[i][0] + 10) {
                    for (int x = 0; x < 10; x++) {
                        for (int y = 0; y < 10; y++)
                            paper[colored[i][0] + x][colored[i][1] + y]++;
                    }
                }
            }
        }
        int count = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                for (int k = 0; k < 4; k++) {
                    //색칠된 칸 인접한 변이 하얀색일 때
                    if (paper[i + dx[k]][j + dy[k]] == 0 && paper[i][j] != 0) {
                        count++;
                    }
                }
            }
        }


        System.out.println(count);
    }
}