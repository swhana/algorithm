package Baekjoon.Silver;

import java.util.Scanner;

public class BOJ_17478_재귀함수가뭔가요 {
    static String line = "";    //전역변수로 선언해야 초기화 영향을 받지 않음
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        answer(n);
    }

    public static void answer(int N) {
        String str = line;

        if (N == 0)    //종료조건
        {
            System.out.println(str+"\"재귀함수가 뭔가요?\"");
            System.out.println(str+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(str+"라고 답변하였지.");
            return;
        }
        System.out.println(str + "\"재귀함수가 뭔가요?\"");
        System.out.println(str + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(str + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(str + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        line += "____";

        answer(N - 1);

        //재귀에서 빠져나오면서 여백이 긴 순서부터 출력된다.
        System.out.println(str+"라고 답변하였지.");
    }
}
