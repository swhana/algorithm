import java.util.Scanner;

/*
    분할정복 응용문제
 */
public class Solution {
    static int N, B, min;
    static int[] arr;
    static boolean[] selected;

    private static void subset(int idx) {
        //기저 조건
        if (idx == N) {
            //0부터 N-1까지 selected배열에
            //부분집합에 포함되는지 유무가 저장되어 있다
            int sum = 0;    //키의 합을 저장할 변수
            for (int i = 0; i < N; i++) {
                if (selected[i] == true) {      //만약 부분집합에 포함되는 원소라면 합에 더하기
                    sum += arr[i];
                }
            }

            if (sum >= B && sum < min)
                min = sum;


            return;
        }

        //유도 조건
        //분기
        selected[idx] = true;   //idx번째 원소를 선택한 채로
        subset(idx + 1);        //다음 원소 선택하러 감
        selected[idx] = false;  //idx번째 원소를 선택하지 않은채로
        subset(idx + 1);        //다음 원소 선택하러 감
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();   //점원의 수
            B = sc.nextInt();   //목표 선반의 높이

            arr = new int[N];   //점원의 키를 저장할 배열
            selected = new boolean[N];  //부분집합의 상태 저장할 배열

            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            min = Integer.MAX_VALUE;

            //부분집합 탐색 시작
            //subset(idx)
            //idx : 0~N-1
            //subset(0)~subset(N-1)
            //subset(N)에서 멈춤
            subset(0);

            System.out.println("#" + tc + " " + (min - B));
        }


    }
}