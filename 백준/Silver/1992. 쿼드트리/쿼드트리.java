import java.util.Scanner;

public class Main {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N][N];

        String str;

        for (int i = 0; i < N; i++) {
            str = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        partition(0, 0, N);
        System.out.println(sb);
    }

    //입력받은 배열이 같은 문자로 이루어져있는지
    public static boolean check(int row, int col, int size) {
        int flag = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != flag)
                    return false;
            }
        }

        return true;
    }

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(arr[row][col]);
            return;
        }

        size /= 2;

        sb.append('(');
        partition(row, col, size);
        partition(row, col + size, size);
        partition(row + size, col, size);
        partition(row + size, col + size, size);
        sb.append(')');
    }


}