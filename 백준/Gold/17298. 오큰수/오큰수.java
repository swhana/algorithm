import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        Stack<Integer> stk = new Stack<>();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] < arr[i])
                arr[stk.pop()] = arr[i];

            stk.push(i);
        }

        while (!stk.isEmpty())
            arr[stk.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}