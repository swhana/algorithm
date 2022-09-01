import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            long A = sc.nextInt();
            if (A == 0) return;

            int cnt = 0;

            for (int i = 1; i <= A; i++) {
                long div = A * A % i;    //인수 찾기
                if (div == 0) {    //i가 A^2의 인수이면
                    long b = A * A / i - i;  //사실 2*B임
                    if (b % 2 == 0 && b / 2 > A)   //(c+b) - (c-b) %2 = 0 -> b는 자연수
                        cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}