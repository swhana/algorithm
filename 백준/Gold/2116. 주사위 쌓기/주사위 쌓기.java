import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dice = new int[N][6];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                dice[i][j] = sc.nextInt();

            }
        }

        int realmax = 0;
        for (int k = 0; k < 6; k++) {
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(dice[0][k]);
            for (int i = 0; i < N; i++) {
                list.add(dice_num(dice[i], list.get(i)));

                int max = 0;
                for (int num : dice[i]) {
                    if (num != list.get(i) && num != dice_num(dice[i], list.get(i)))
                        max = Math.max(max, num);
                }
                sum += max;
            }
            realmax = Math.max(realmax, sum);
        }
        System.out.println(realmax);

    }

    public static int dice_num(int[] arr, int input) {
        int idx = 0;

        for (int i : arr) {
            if (input == i) {
                break;
            }
            idx++;
        }

        switch (idx) {
            case 0:
                return arr[5];
            case 1:
                return arr[3];
            case 2:
                return arr[4];
            case 3:
                return arr[1];
            case 4:
                return arr[2];
            case 5:
                return arr[0];
            default:
                return -1;
        }
    }
}