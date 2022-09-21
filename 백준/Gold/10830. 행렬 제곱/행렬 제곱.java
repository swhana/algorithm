import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int N;

    public static int[][] divcon(long B) {
        /*
            <80% 오답 반례>
            입력값
            2 1
            1000 1000
            1000 1000

            정답
            0 0
            0 0

            오답
            1000 1000
            1000 1000

            B가 1일 경우 matrix_multiple 함수를 거치지 않기 때문에
            주어진 함수 자체 원소값이 1000을 넘는 경우 1000으로 나눈 나머지 처리를 해줘야 한다
         */
        if (B == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] >= 1000)
                        arr[i][j] %= 1000;
                }
            }
            return arr;
        }


        if (B == 2) {
            return matrix_multiple(arr, arr);
        }

        int[][] res = divcon(B / 2);    //이렇게 하니까 80%에서 오답


        //이렇게 하면 같은 divcon재귀를 2번하게 되서 연산시간이 배로 늘어난다.
        //int[][] res = matrix_multiple(divcon(B/2), divcon(B/2));


        if (B % 2 == 0)
            return matrix_multiple(res, res);
        else
            return matrix_multiple(matrix_multiple(res, res), arr);
    }


    //크기가 같은 두 NxN행렬의 곱을 계산해주는 함수
    public static int[][] matrix_multiple(int[][] arr1, int[][] arr2) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int r = 0; r < N; r++) {
                    res[i][j] += (arr1[i][r] * arr2[r][j]) % 1000;
                    res[i][j] %= 1000;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        long B = sc.nextLong(); //B의 범위 확인!

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] res = divcon(B);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}