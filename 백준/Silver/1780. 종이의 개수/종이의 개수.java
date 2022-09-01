import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int zero = 0;
    static int minus = 0;
    static int plus = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        partition(0, 0, N);
        System.out.println(minus + "\n" + zero + "\n" + plus);
    }

    static boolean check(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != arr[row][col])
                    return false;
            }
        }

        return true;
    }

    static void partition(int row, int col, int size) {
        //같은 숫자면
        if (check(row, col, size)) {
            int a = arr[row][col];
            if (a == 0)
                zero++;
            else if (a == -1)
                minus++;
            else
                plus++;

            return;
        }

        //아니면
        size /= 3;

        partition(row, col, size);
        partition(row, col + size, size);
        partition(row, col + size * 2, size);
        partition(row + size, col, size);
        partition(row + size, col + size, size);
        partition(row + size, col + size * 2, size);
        partition(row + size * 2, col, size);
        partition(row + size * 2, col + size, size);
        partition(row + size * 2, col + size * 2, size);

    }
}