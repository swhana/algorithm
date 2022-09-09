import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] house; //집의 좌표를 담는 배열


    static int canInstall(int distance) {
        int cnt = 1;    //하나는 무조건 설치
        int last_locate = house[0];

        for (int i = 1; i < house.length; i++) {
            //목표간격 이상(목표간격 포함) 떨어져 있는 집을 발견
            if (house[i] - last_locate >= distance) {
                cnt++;
                last_locate = house[i];
            }
            //발견 못했을 시 last_locate는 그대로
        }
        return cnt; // 공유기 설치한 집의 수를 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house); //정렬 필수

        int lo = 1;
        int hi = house[N - 1] - house[0] + 1;   //house가 하나일 경우 생각하면 +1(92% fail case)

        while (lo < hi) {   //upper bound 방식
            int mid = (lo + hi) / 2;    //설치하는 간격

            //설치한 공유기가 목표보다 적다 -> 설치한 간격이 너무 길다
            if (canInstall(mid) < M) {
                hi = mid;       //간격을 줄인다
            } else
                lo = mid + 1;   //간격을 늘린다
        }

        //탐색값을 초과하는 가장 첫번째 값이 lo이기 때문에 -1을 해주면 목표값의 최대치(Upper Bound)가 나온다
        System.out.println(lo - 1);
    }
}