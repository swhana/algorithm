import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //주사위 개수
        int[][] dice = new int[N][6];   //주사위 별로 각 면의 숫자를 담기위한 배열

        //입력부
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                dice[i][j] = sc.nextInt();
            }
        }

        //한 옆면의 숫자의 합의 최댓값
        int realmax = 0;
        //시작값 정하기
        for (int k = 0; k < 6; k++) {
            int sum = 0;    //한 옆면의 숫자의 합
            ArrayList<Integer> list = new ArrayList<>();    //눈에 안 보이는 면의 숫자들을 담을 리스트
            list.add(dice[0][k]);   //맨 밑 주사위만 돌려가면서 시작값 바꾸기
            for (int i = 0; i < N; i++) {
                list.add(dice_num(dice[i], list.get(i)));   //주사위 밑면을 입력해서 윗면의 값을 리스트에 넣는 과정 반복
                int max = 0;    //주사위 옆면 숫자 중 최댓값
                for (int num : dice[i]) {
                    if (num != list.get(i) && num != dice_num(dice[i], list.get(i)))    //주사위 밑면과 윗면만 아니면
                        max = Math.max(max, num);
                }
                sum += max; //옆면 숫자중 최댓값이니까 이걸 옆면들의 합에 더해준다
            }
            realmax = Math.max(realmax, sum);   //그 중에서 최댓값 찾기
        }
        System.out.println(realmax);

    }

    //숫자를 입력하면 그 숫자에 해당하는 면을 찾아 반대편 면의 숫자를 반환해주는 메소드
    public static int dice_num(int[] arr, int input) {
        int idx = 0;

        for (int i : arr) {
            if (input == i) {
                break;
            }
            idx++;  //idx가 if문보다 위에 있으면 잘못된 값이 나올 때가 있다
        }

        //반대편 면의 숫자를 반환하는 과정
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