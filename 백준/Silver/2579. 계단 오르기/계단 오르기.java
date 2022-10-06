import java.util.Scanner;
/*
    n번째 계단에 오르는 경우의 수
            == n
          ==   n-1
        ==     n-2
      ==       n-3
    ==         n-4
    n-2번째 계단에서 오르기
    n-3 -> n-1을 거쳐 오르기

    n-1번째에서 바로 올라가는걸 계산 안하는 이유는 n-2 -> n-1 -> n으로 가는 경우의 수를 피하기 위함

    각 계단의 점수를 stairs[] 배열에 저장하고
    각 계단을 오르는 최대 점수를 result[]에 저장  << result[] 배열을 DP배열이라고 생각하면 된다

    계단이 3개 미만일 경우는 직접 계산해줘야함
 */


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] stairs = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            stairs[i] = sc.nextInt();
        }

        //Bottom-Up 방식
        //계단이 1개밖에 없는 경우 예외처리(92% 코너케이스)
        if (N > 0)
            result[0] = stairs[0];
        //계단이 2개밖에 없는 경우 예외처리
        if (N > 1)
            result[1] = stairs[0] + stairs[1];
        //계단이 3개밖에 없는 경우 예외처리
        if (N > 2)
            result[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        if (N > 3) {
            for (int i = 3; i < N; i++) {
                result[i] = Math.max(result[i - 2] + stairs[i], result[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }

        System.out.println(result[N - 1]);
    }
}