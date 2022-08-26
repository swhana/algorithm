import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());


        for (int k = 1; k <= tc; k++) {
            boolean flag = true;    //에러판별기
            String func = br.readLine();    //함수(RDD같은거)
            int n = Integer.parseInt(br.readLine());    //배열 크기

            Deque<Integer> deq = new LinkedList<>();
            String array = br.readLine();    //[]배열 받기
            array = array.substring(1, array.length() - 1); //[]잘라내기

            st = new StringTokenizer(array, ",");   //, 빼내기

            for (int i = 0; i < n; i++) {               //배열 입력
                deq.offerLast(Integer.parseInt(st.nextToken()));
            }

            int Rcount = 0;
            for (int i = 0; i < func.length(); i++) {
                if (func.charAt(i) == 'R') {
                    Rcount++;
                } else if (func.charAt(i) == 'D') {
                    if (Rcount % 2 == 0) {     //R갯수가 짝수면 정상인 상태, 홀수면 아닌상태
                        if (deq.peekFirst() == null) {
                            flag = false;
                            break;
                        } else
                            deq.pollFirst();
                    } else {
                        if (deq.peekLast() == null) {
                            flag = false;
                            break;
                        } else
                            deq.pollLast();
                    }

                }
            }
            StringBuilder sb = new StringBuilder();
            if (flag) {
                sb.append("[");
                if (Rcount % 2 == 0) {
                    while (!deq.isEmpty()) {
                        sb.append(deq.pollFirst());
                        if (deq.size() != 0)
                            sb.append(",");
                    }
                    sb.append("]");
                    System.out.println(sb);
                } else {
                    while (!deq.isEmpty()) {
                        sb.append(deq.pollLast());
                        if (deq.size() != 0)
                            sb.append(",");
                    }
                    sb.append("]");
                    System.out.println(sb);
                }
            } else
                System.out.println("error");
        }
    }
}