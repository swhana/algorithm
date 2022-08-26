import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //큐의 크기 N
        int M = sc.nextInt(); //뽑아내려고 하는 수의 개수 M

        int[] arr = new int[M];
        for (int i = 0; i < M; i++)
            arr[i] = sc.nextInt();  //뽑아내려고 하는 수의 위치

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            deque.offerLast(i);

        int cnt = 0;
        int temp;
        for (int i = 0; i < M; i++) {
            //배열의 첫번째 위치에 찾으려던 수가 있을 경우
            if (deque.peekFirst() == arr[i]) {  //arr[i] : 뽑으려는 수의 순서, => 순서 = 배열입력값이 되도록 했으니 상관없다
                deque.pollFirst();
            }
            //없을 경우 찾아 나서야 한다
            else {
                temp = 0;
                //찾을때까지 2번 연산 반복(2번연산횟수 = 전체 덱 원소 개수 - 3번연산횟수)
                while (deque.peekFirst() != arr[i]) {
                    deque.offerLast(deque.pollFirst());
                    temp++;
                }
                //찾았으면 2번과 3번 중 더 적은 연산을 더하고
                cnt += (temp < deque.size() - temp) ? temp : deque.size() - temp;

                //그 원소를 1번연산으로 빼내준다
                deque.pollFirst();
            }
        }
        System.out.println(cnt);
    }
}