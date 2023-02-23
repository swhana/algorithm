import java.util.Scanner;

public class Main {
    static int N, M;
    static String[] board;
    public static int checkW(int st, int row){
        if(st + 7 >= M) return 0;
        int cnt = 0;

        for(int i=st; i<st+8; i++){
           if((i-st)%2 == 0){
               if(board[row].charAt(i) != 'W') cnt++;
           }

           if((i-st)%2 == 1){
               if(board[row].charAt(i) != 'B') cnt ++;
           }
        }

        return cnt;
    }

    public static int checkB(int st, int row){
        if(st + 7 >= M) return 0;
        int cnt = 0;

        for(int i=st; i<st+8; i++){
            if((i-st)%2 == 0){
                if(board[row].charAt(i) != 'B') cnt++;
            }

            if((i-st)%2 == 1){
                if(board[row].charAt(i) != 'W') cnt ++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        N = Integer.parseInt(sc.next());
        M = Integer.parseInt(sc.next());
        sc.nextLine();
        board = new String[N];
        for(int i=0; i<N; i++) board[i] = sc.nextLine();

        int minTotal = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){ //가로
            for(int j=0; j<N; j++){ //세로
                if(i+7<M && j+7<N){
                    char st = board[j].charAt(i);
                    int totalW = 0;
                    int totalB = 0;

                    totalW = checkW(i, j) + checkW(i, j+2) + checkW(i, j+4) + checkW(i, j+6)
                            + checkB(i, j+1) + checkB(i, j+3) + checkB(i, j+5) + checkB(i, j+7);


                    totalB = checkB(i, j) + checkB(i, j+2) + checkB(i, j+4) + checkB(i, j+6)
                            + checkW(i, j+1) + checkW(i, j+3) + checkW(i, j+5) + checkW(i, j+7);

                    if(totalW < totalB && totalW < minTotal) minTotal = totalW;
                    if(totalB <= totalW && totalB < minTotal) minTotal = totalB;
                }
            }
        }
        System.out.println(minTotal);
    }
}
