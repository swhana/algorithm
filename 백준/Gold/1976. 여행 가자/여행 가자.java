import java.util.Scanner;

public class Main {
    static int[] p;
    static int[] rank;

    //합집합의 대표자(조상)를 찾는 메소드
    public static int find(int x) {
        if (x != p[x])
            p[x] = find(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] > rank[py]) {
            p[py] = px; //px에 편입
        } else {
            p[px] = py;
            if (rank[px] == rank[py])
                rank[py]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        p = new int[N + 1];
        rank = new int[N + 1];
        int[] city = new int[N];

        //까먹지 말자...
        for (int i = 1; i < N + 1; i++)
            p[i] = i;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[j] = sc.nextInt();
                if (city[j] == 1 && find(i + 1) != find(j + 1))
                    union(i + 1, j + 1);
            }
        }

        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = sc.nextInt();
        }

        boolean flag = true;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (find(plan[i]) != find(plan[j])) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}