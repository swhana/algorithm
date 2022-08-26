import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

            /*문자열을 계속 뒤집는건 시간초과가 나기 때문에
             D가 입력될 때나 문자열 출력시에 R갯수를 체크해
             문자열이 정방향인지 역방향인지만 확인하면 된다*/
            int Rcount = 0;
            for (int i = 0; i < func.length(); i++) {
                if (func.charAt(i) == 'R') {
                    Rcount++;
                } else if (func.charAt(i) == 'D') {
                    if (Rcount % 2 == 0) {     //R갯수가 짝수면 정방향, 홀수면 역방향
                        //정방향 체크
                        if (deq.peekFirst() == null) { //에러 플래그가 false면 error출력
                            flag = false;
                            break;
                        } else
                            deq.pollFirst();
                    } else {
                        //역방향 체크
                        if (deq.peekLast() == null) { //에러 플래그가 false면 error출력
                            flag = false;
                            break;
                        } else
                            deq.pollLast();
                    }
                }
            }

            //출력부
            if (flag) {
                bw.write("[");
                //정방향일 경우
                if (Rcount % 2 == 0) {
                    while (!deq.isEmpty()) {
                        bw.write(String.valueOf(deq.pollFirst()));
                        if (deq.size() != 0)
                            bw.write(",");
                    }
                    bw.write("]");
                }
                //역방향일 경우
                else {
                    while (!deq.isEmpty()) {
                        bw.write(String.valueOf(deq.pollLast()));
                        if (deq.size() != 0)
                            bw.write(",");
                    }
                    bw.write("]");
                }
            } else
                bw.write("error");
            bw.write("\n");

            bw.flush();
        }
        br.close();
        bw.close();
    }
}