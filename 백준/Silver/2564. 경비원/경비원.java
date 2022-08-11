import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();   //직사각형 가로 길이
        int y = sc.nextInt();   //직사각형 세로 길이
        int total = x * 2 + y * 2; //전체 둘레

        int N = sc.nextInt();   //상점 수
        int[][] shop = new int[N + 1][2];
        for (int i = 0; i < N + 1; i++) {
            shop[i][0] = sc.nextInt();
            shop[i][1] = sc.nextInt();
        }

        //shop[N] : 경비

        int sum = 0;
        int sum_left = 0;
        int sum_right = 0;

        //좌표 재정립(좌측 상단의 꼭짓점을 원점으로 일직선으로 생각)
        for (int i = 0; i < N + 1; i++) {
            if (shop[i][0] == 2) {
                shop[i][1] = x + y + x - shop[i][1];
            } else if (shop[i][0] == 3) {
                shop[i][1] = x + y + x + y - shop[i][1];
            } else if (shop[i][0] == 4) {
                shop[i][1] = x + shop[i][1];
            }
        }

        //왼쪽으로 갔을 때, 오른쪽으로 갔을 때 거리 둘다 구해서 최단거리를 최종 결과에 대입
        for (int i = 0; i < N; i++) {
            if (shop[i][1] >= shop[N][1]) {
                sum_left = shop[N][1] + total - shop[i][1];
                sum_right = shop[i][1] - shop[N][1];
                sum += Math.min(sum_left, sum_right);
            } else {
                sum_left = shop[N][1] - shop[i][1];
                sum_right = total - shop[N][1] + shop[i][1];
                sum += Math.min(sum_left, sum_right);
            }
        }

        System.out.println(sum);

    }
}