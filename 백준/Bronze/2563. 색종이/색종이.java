import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] colored = new int[N][2];

        for (int i = 0; i < N; i++) {
            colored[i][0] = sc.nextInt();
            colored[i][1] = sc.nextInt();
        }

        int[][] paper = new int[101][101];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 101; j++) {
                if (j >= colored[i][0] && j < colored[i][0] + 10) {
                    for (int x = 0; x < 10; x++) {
                        for (int y = 0; y < 10; y++)
                            paper[colored[i][0]+x][colored[i][1]+y]++;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (paper[i][j] != 0)
                    count++;
            }
        }

        System.out.println(count);
    }
}