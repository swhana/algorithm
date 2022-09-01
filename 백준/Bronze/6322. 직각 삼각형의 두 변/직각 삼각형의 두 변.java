import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = 0;
        while (true) {
            tc++;
            double a = sc.nextInt();
            double b = sc.nextInt();
            double c = sc.nextInt();
            if (a == b && b == c && c == 0.0)
                return;

            System.out.println("Triangle #" + tc);
            if (a == -1) {
                if (c * c - b * b > 0)
                    System.out.printf("a = %.3f\n", Math.sqrt(c * c - b * b));
                else
                    System.out.println("Impossible.");
                System.out.println();
            }

            if (b == -1) {
                if (c * c - a * a > 0)
                    System.out.printf("b = %.3f\n", Math.sqrt(c * c - a * a));
                else
                    System.out.println("Impossible.");
                System.out.println();
            }

            if (c == -1) {
                System.out.printf("c = %.3f\n", Math.sqrt(a * a + b * b));
                System.out.println();
            }
        }
    }
}