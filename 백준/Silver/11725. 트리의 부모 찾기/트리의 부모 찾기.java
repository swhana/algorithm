import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> tree[] = new LinkedList[N + 1]; //LinkedList 배열 N+1개 생성
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new LinkedList<Integer>();
        }


        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            tree[a].add(b); //tree[a]의 요소에 b를 추가
            tree[b].add(a); //누가 부모인지 모르기 때문에 양방향 연결리스트
        }

        //자식을 먼저 쭉 탐색하기 때문에 BFS방식
        //탐색 순서를 저장할 큐
        Queue<Integer> search = new LinkedList<>();
        search.add(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        int[] parent = new int[N + 1];

        //큐가 다 비워질 때까지 탐색 실행
        while (!search.isEmpty()) {
            int num = search.poll();   //탐색할 노드번호 선택
            for (int i : tree[num]) { //노드의 자식들 탐색
                if (!visited[i]) {    //방문한 적이 없다면
                    visited[i] = true;  //방문했으니 true로 바꿔주고
                    parent[i] = num;    //i의 부모는 num입니다
                    search.add(i);      //이제 i를 탐색목록에 추가하고 빠져나오기
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);  //2번 노드부터 부모 출력
        }
    }
}