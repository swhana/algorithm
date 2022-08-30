import java.util.Scanner;

public class Main {
    static int white;
    static int blue;
    static boolean[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        board = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int in = sc.nextInt();
                board[i][j] = in == 1;
            }
        }

        partition(0, 0, N);
        System.out.println(white + "\n" + blue);
    }

    static boolean colorCheck(int row, int col, int size) {
        boolean color = board[row][col];    //true = blue, false = white

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color)
                    return false;
            }
        }

        return true;
    }

    static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {   //전체가 같은 색으로 칠해져 있을 경우
            if (board[row][col])
                blue++;
            else
                white++;
            return;
        }

        size /= 2;  //size 절반
        partition(row, col, size);
        partition(row, col + size, size);
        partition(row + size, col, size);
        partition(row + size, col + size, size);
    }
}