import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Queue {
        public int front = -1;
        public int rear = -1;
        private int size;
        public int[] arr;

        public Queue(int size) {
            this.size = size;
            this.arr = new int[size];
            Arrays.fill(arr, -1);
        }

        public void push(int x) {
            arr[++rear] = x;
        }

        public int pop() {
            if (rear > front)
                return arr[++front];
            else
                return -1;
        }

        public int size() {
            size = rear - front;
            return size;
        }

        public int empty() {
            if (front >= rear)
                return 1;
            else
                return 0;
        }

        public int front() {
            if (empty() == 1)
                return -1;
            else
                return arr[front + 1];
        }

        public int back() {
            if (empty() == 1)
                return -1;
            else
                return arr[rear];
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(N);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();

            if (input.contains("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue.push(x);
            } else if (input.equals("pop")) {
                bw.write(queue.pop() + "\n");
            } else if (input.equals("size")) {
                bw.write(queue.size() + "\n");

            } else if (input.equals("empty")) {
                bw.write(queue.empty() + "\n");

            } else if (input.equals("front")) {
                bw.write(queue.front() + "\n");

            } else if (input.equals("back")) {
                bw.write(queue.back() + "\n");

            }
        }
        bw.flush();
        bw.close();
    }
}