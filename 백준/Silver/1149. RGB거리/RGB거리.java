import java.util.Scanner;
/*
    매 행의 최소값을 담는 배열 res[][]을 가정해보자

    res[depth][0]는 어떻게 표현해야 할까?
    res[depth][0] = arr[depth][0] + (res[depth-1][1]과 res[depth-1][2]중 작은 수)
    이 점화식을 유지해 준다면 계속 최소값을 저장하면서 내려갈 수 있다
    
 */


public class Main {
    static int[][] arr;
    static int N;
    static int[][] res;

    //depth행의 idx열 자리를 채워주는 함수
    static void dp(int depth, int idx) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != idx) {
                if (min > res[depth - 1][i])
                    min = res[depth - 1][i];
            }
        }
        //이렇게 하면 res[depth]중 최솟값이 정해진다
        //이 값을 arr[depth+1][idx]랑 더하면 res[depth+1][idx]가 만들어진다

        res[depth][idx] = arr[depth][idx] + min;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N][3];
        res = new int[N][3];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        res[0][0] = arr[0][0];
        res[0][1] = arr[0][1];
        res[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp(i, j);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i : res[N - 1]) {
            ans = Math.min(i, ans);
        }

        System.out.println(ans);
    }
}