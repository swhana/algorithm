import java.util.Scanner;

public class Main {
    /*
        전체 지도와 똑같은 크기의 배열 res[][]을 하나 더 생각해보자
        각 칸에 그 칸까지 도달할 수 있는 방법의 수를 저장한다면

        res[a][b]에 도달하는 방법의 수는
        res[a][b] = res[a-1][b] + res[a][b-1] + res[a-1][b-1]뿐이다
        왜냐하면 파이프가 이동할 수 있는건 가로, 세로, 대각선뿐이니까
     */

    static int N;

    static int[][] arr;
    static long[][][] res;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        //마지막 인덱스 : 파이프의 상태
        //0: 가로, 1:세로, 2:대각선
        res = new long[N][N][3];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //맨 윗줄 가로방향만 설정해줌
        for (int i = 1; i < N; i++) {
            res[0][i][0] = 1;
            if (arr[0][i] == 1) {
                res[0][i][0] = 0;
                break;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 2; j < N; j++) {
                //가로로 올 수 있는 경우의 수 = 왼쪽칸에서 가로로 오기 + 왼쪽칸에서 대각선으로 오기
                if (arr[i][j] != 1) {
                    res[i][j][0] = res[i][j - 1][0] + res[i][j - 1][2];
                    res[i][j][1] = res[i - 1][j][1] + res[i - 1][j][2];
                    if (arr[i - 1][j] != 1 && arr[i][j - 1] != 1) {
                        res[i][j][2] = res[i - 1][j - 1][0] + res[i - 1][j - 1][1] + res[i - 1][j - 1][2];
                    }
                }
            }
        }


        System.out.println(res[N - 1][N - 1][0] + res[N - 1][N - 1][1] + res[N - 1][N - 1][2]);
    }
}