import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //학생 수
        int K = sc.nextInt();   //방 최대인원수

        int[][] student = new int[2][7];
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int y = sc.nextInt();
            student[s][y]++;
        }

        int room = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++) {
                if (student[i][j] % K == 0)
                    room += student[i][j] / K;
                else
                    room += (student[i][j] / K) + 1;
            }
        }

        System.out.println(room);
    }
}