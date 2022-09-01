import java.util.Scanner;

public class Main {

    static long A;
    static long B;
    static long C;

    //int로 하면 틀려요
    static long multiple(long num, long cnt) {
        if (cnt == 1) {
            return num % C;
        }

        if (cnt % 2 == 0) {
            cnt /= 2;
            long temp;
            temp = multiple(num, cnt);
            return (temp * temp) % C;
        } else {
            cnt /= 2;
            long temp;
            temp = multiple(num, cnt);
            return ((temp * temp) % C * num) % C;    //여기서 한번 더 안나눠주면 범위초과해요
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(multiple(A, B));
    }
}
