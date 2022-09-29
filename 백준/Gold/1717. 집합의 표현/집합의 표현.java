import java.util.Scanner;

public class Main {
    static int[] p;     //대표자

    public static int find(int x) {
        if (x != p[x])
            p[x] = find(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        p[py] = px;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        p = new int[N + 1];
        for (int i = 1; i < N + 1; i++) p[i] = i;

        for (int i = 0; i < M; i++) {
            int cal = sc.nextInt();
            int st = sc.nextInt();
            int ed = sc.nextInt();

            if (cal == 0) {
                union(st, ed);
            }

            if (cal == 1) {
                if (find(st) == find(ed)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }
}