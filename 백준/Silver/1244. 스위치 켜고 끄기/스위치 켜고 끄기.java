import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 스위치 갯수
        boolean[] swt = new boolean[N];
        int[] flag = new int[N];
        for (int i = 0; i < N; i++) {
            flag[i] = sc.nextInt();
            swt[i] = flag[i] == 1;
        }

        int M = sc.nextInt();
        int[][] student = new int[M][2];

        for (int i = 0; i < M; i++) {
            student[i][0] = sc.nextInt();       //성별
            student[i][1] = sc.nextInt();       //스위치 변경값
        }

        for (int i = 0; i < M; i++) {
            //남학생
            if (student[i][0] == 1) {
                int idx = student[i][1] - 1;
                while (idx < N) {
                    swt[idx] = !swt[idx];
                    idx += student[i][1];
                }
            }
            //여학생
            else if (student[i][0] == 2) {
                int idx = student[i][1] - 1;
                swt[idx] = !swt[idx];
                for (int j = 1; j < N; j++) {
                    if (!(idx + j >= N || idx - j < 0)) {
                        if (swt[idx + j] == swt[idx - j]) {
                            swt[idx + j] = !swt[idx + j];
                            swt[idx - j] = !swt[idx - j];
                        } else
                            break;
                    } else
                        break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (swt[i]) sb.append(1 + " ");
            else sb.append(0 + " ");

            if (i % 20 == 19)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}