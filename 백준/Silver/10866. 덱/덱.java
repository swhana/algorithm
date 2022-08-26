import java.util.Scanner;

public class Main {
    public static class Deque {
        public int front = 0;   //front 위치
        public int rear = -1;    //rear 위치
        private int size = rear - front + 1;       //size
        private int array_size;
        public int[] arr;

        //생성자
        public Deque(int size) {
            array_size = size;
            arr = new int[array_size];
        }

        public void push_front(int x) {
            int[] new_arr = new int[array_size];  //size가 더 큰 배열 생성
            for (int i = front; i <= rear; i++)  //배열 복사
                new_arr[i + 1] = arr[i];

            new_arr[front] = x;
            arr = new_arr;
            rear++; //rear는 한칸 뒤로 밀려났으니 +1
        }

        public void push_back(int x) {
            arr[++rear] = x;
        }

        public int pop_front() {
            if (rear - front + 1 > 0)
                return arr[front++];
            else
                return -1;
        }

        public int pop_back() {
            if (rear - front + 1 > 0)
                return arr[rear--];
            else
                return -1;
        }

        public int size() {
            size = rear - front + 1;
            return size;
        }

        public int empty() {
            if (rear - front + 1 <= 0)
                return 1;
            else
                return 0;
        }

        public int front() {
            if (rear - front + 1 <= 0)
                return -1;
            else
                return arr[front];
        }

        public int back() {
            if (rear - front + 1 <= 0)
                return -1;
            else
                return arr[rear];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //명령 수
        Deque deque = new Deque(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            if (input.contains("push_back")) {
                int x = sc.nextInt();
                deque.push_back(x);
            } else if (input.contains("push_front")) {
                int x = sc.nextInt();
                deque.push_front(x);
            } else if (input.equals("pop_front")) {
                sb.append(deque.pop_front()).append("\n");
            } else if (input.equals("pop_back")) {
                sb.append(deque.pop_back()).append("\n");
            } else if (input.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (input.equals("empty")) {
                sb.append(deque.empty()).append("\n");
            } else if (input.equals("front")) {
                sb.append(deque.front()).append("\n");
            } else if (input.equals("back")) {
                sb.append(deque.back()).append("\n");
            }
        }
        System.out.println(sb);
    }
}