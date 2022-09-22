import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] visited;
    static ArrayList<int[]> list = new ArrayList<>();


    private static void dfs(int row, int col) {
        //한 행을 다 순회했을 경우 다음 행으로 이동
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        //모든 행과 열을 순회했을 경우 출력하고 종료
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    map[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }

        dfs(row, col + 1);
    }

    //r행 c열에 num이 들어가도 되는지 체크
    private static boolean check(int r, int c, int num) {

        //i를 넣을 수 있는가?
        //행 탐색하면서 i랑 중복되는 칸이 없는지 체크
        for (int j = 0; j < 9; j++) {
            if (num == map[r][j]) {   //겹치는 수가 있다!
                return false;

            }
        }

        //가로를 통과했으니 세로 체크
        for (int j = 0; j < 9; j++) {
            if (num == map[j][c]) {   //겹치는 수가 있다!
                return false;
            }
        }

        for (int m = (r / 3) * 3; m < (r / 3) * 3 + 3; m++) {
            for (int n = (c / 3) * 3; n < (c / 3) * 3 + 3; n++) {
                if (num == map[m][n]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[9][9];
        visited = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }


        dfs(0, 0);


    }
}