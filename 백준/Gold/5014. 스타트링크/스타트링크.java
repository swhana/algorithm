import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
        ㅣ F층(건물의 높이)
        ㅣ
        ㅣ G층(스타트링크가 있는 곳) < 변할 수 있음
        ㅣ
        ㅣ
        ㅣ
        ㅣ S층(현재 위치) < 변할 수 있음
        ㅣ
    U버튼 = +U층
    D버튼 = -D층
    범위를 벗어나면, 실행되지 않음
    최소의 버튼을 눌러서 G층에 가는 방법 찾기
    갔던 층을 다시 되돌아올 일은 없다 < 그러면 그 전에 눌렀던 버튼은 모두 의미가 없어지니까

    각 층에서 갈 수 있는 방법은 딱 3가지 U만큼 올라가거나 D만큼 내려가거나 제자리에 있거나
    visited[true]면 bfs를 끝내면되고
    마지막에 visted[G]가 false면 use the stairs 출력
    최소값?
    현재 위치가 G보다 낮으면 +U 높으면 -D하면 되지않을까


 */
public class Main {
    static int F;   //최대 층
    static int S;   //시작 층
    static int G;   //목표 층
    static int U;   //올라가는 층수
    static int D;   //내려가는 층수
    static int[] visited;
    static LinkedList<Integer>[] edge;
    static Queue<Integer> queue = new LinkedList<>();

    static void bfs(LinkedList<Integer>[] edge, int start) {
        visited[start] = 1;  //현재 층 방문처리
        queue.add(start);
        while (!queue.isEmpty()) {
            int floor = queue.poll();
            if (floor == G) return;
            if (floor + U <= F && visited[floor + U] == 0) {
                visited[floor + U] = visited[floor] + 1;
                queue.add(floor + U);
            }
            if (floor - D > 0 && visited[floor - D] == 0) {
                visited[floor - D] = visited[floor] + 1;
                queue.add(floor - D);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();   //전체 층

        visited = new int[F + 1];
        edge = new LinkedList[F + 1];

        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        for (int i = 0; i < F + 1; i++) {
            edge[i] = new LinkedList<>();
        }

        bfs(edge, S);

        if (visited[G] != 0)
            System.out.println(visited[G] - 1);
        else
            System.out.println("use the stairs");
    }
}