import java.util.Scanner;

public class Main {
    static int[] p;


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

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            p = new int[N + 1];

            for (int i = 1; i < N + 1; i++) {
                p[i] = i;
            }

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                int st = sc.nextInt();
                int ed = sc.nextInt();

                if (find(st) == find(ed)) continue;
                union(st, ed);
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}