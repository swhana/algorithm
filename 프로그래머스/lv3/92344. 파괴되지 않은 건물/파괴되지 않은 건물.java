import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        
        int[][] sum = new int[r+1][c+1];
        
        //스킬 횟수만큼 반복
        for(int i=0; i<skill.length; i++){
            int type = (int)Math.pow(-1, skill[i][0]); //1이면 공격, 2면 회복
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int deg = skill[i][5]; //수치
            
            if(r1 < r && c1 < c) sum[r1][c1] += type*deg;
            if(r1 < r && c2+1 < c) sum[r1][c2+1] -= type*deg;
            if(r2+1 < r && c1 < c) sum[r2+1][c1] -= type*deg;
            if(r2+1 < r && c2+1 < c) sum[r2+1][c2+1] += type*deg;
        }
        
        for(int i=1; i<c; i++){
            for(int j=0; j<c; j++){
                sum[i][j] += sum[i-1][j];
            }
        }
        
        for(int i=0; i<r; i++){
            for(int j=1; j<r; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] + sum[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}