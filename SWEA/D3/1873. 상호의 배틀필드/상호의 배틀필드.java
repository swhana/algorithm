import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int k = 1; k <= T; k++) {

            int H = sc.nextInt();
            int W = sc.nextInt();

            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String str = sc.next();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int N = sc.nextInt();
            String str2 = sc.next();

            for (int i = 0; i < N; i++) {
                char input = str2.charAt(i);
                if (input == 'U')
                    Up(map, H, W);
                else if (input == 'D')
                    Down(map, H, W);
                else if (input == 'L')
                    Left(map, H, W);
                else if (input == 'R')
                    Right(map, H, W);
                else if (input == 'S')
                    Shoot(map, H, W);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + k + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    public static void Shoot(char[][] map, int H, int W) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '>') {
                    int nc = j;
                    while (nc < W) {   //맵 끝까지 날아가기
                        if (map[i][nc] == '*') {    //벽돌벽을 만나면
                            map[i][nc] = '.';       //평지로 바꾸고 break
                            return;
                        } else if (map[i][nc] == '#') //강철벽을 만나면 break
                            return;
                        else {
                            nc++;
                            if (nc >= W)//맵밖을 넘어가면 break
                                return;
                        }
                    }
                } else if (map[i][j] == '<') {
                    int nc = j;
                    while (nc >= 0) {   //맵 끝까지 날아가기
                        if (map[i][nc] == '*') {    //벽돌벽을 만나면
                            map[i][nc] = '.';       //평지로 바꾸고 break
                            return;
                        } else if (map[i][nc] == '#')  //강철벽을 만나면 break
                            return;
                        else {
                            nc--;
                            if (nc < 0)//맵밖을 넘어가면 break
                                return;
                        }
                    }
                } else if (map[i][j] == '^') {
                    int nr = i;
                    while (nr >= 0) {  //맵 끝까지 날아가기
                        if (map[nr][j] == '*') { //벽돌벽을 만나면
                            map[nr][j] = '.'; //평지로 바꾸고 break
                            return;
                        } else if (map[nr][j] == '#') //강철벽을 만나면 break
                            return;
                        else {
                            nr--;
                            if (nr < 0)//맵밖을 넘어가면 break
                                return;
                        }
                    }
                } else if (map[i][j] == 'v') {
                    int nr = i;
                    while (nr < H) {  //맵 끝까지 날아가기
                        if (map[nr][j] == '*') { //벽돌벽을 만나면
                            map[nr][j] = '.';//평지로 바꾸고 break
                            return;
                        } else if (map[nr][j] == '#')  //강철벽을 만나면 break
                            return;
                        else {
                            nr++;
                            if (nr >= H)    //맵밖을 넘어가면 break
                                return;
                        }
                    }
                }
            }
        }
    }

    public static void Up(char[][] map, int H, int W) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '>' || map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v') {
                    if (i - 1 >= 0) {
                        if (map[i - 1][j] == '.') {
                            map[i - 1][j] = '^';
                            map[i][j] = '.';
                            return;
                        } else {
                            map[i][j] = '^';
                            return;
                        }
                    } else {
                        map[i][j] = '^';
                        return;
                    }
                }
            }
        }
    }

    public static void Down(char[][] map, int H, int W) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '>' || map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v') {
                    if (i + 1 < H) {
                        if (map[i + 1][j] == '.') {
                            map[i + 1][j] = 'v';
                            map[i][j] = '.';
                            return;
                        } else {
                            map[i][j] = 'v';
                            return;
                        }
                    } else {
                        map[i][j] = 'v';
                        return;
                    }
                }
            }
        }
    }

    public static void Left(char[][] map, int H, int W) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '>' || map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v') {
                    if (j - 1 >= 0) {
                        if (map[i][j - 1] == '.') {
                            map[i][j - 1] = '<';
                            map[i][j] = '.';
                            return;
                        } else {
                            map[i][j] = '<';
                            return;
                        }
                    } else {
                        map[i][j] = '<';
                        return;
                    }
                }
            }
        }
    }

    public static void Right(char[][] map, int H, int W) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '>' || map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v') {
                    if (j + 1 < W) {
                        if (map[i][j + 1] == '.') {
                            map[i][j + 1] = '>';
                            map[i][j] = '.';
                            return;
                        } else {
                            map[i][j] = '>';
                            return;
                        }
                    } else {
                        map[i][j] = '>';
                        return;
                    }
                }
            }
        }
    }
}