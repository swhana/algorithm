import java.util.*;
import java.io.*;

public class Main {
	static int N,wr, wc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		char[][] map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int hr = -1;
		int hc = -1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == '*') {
					int check = 0;
					for(int n=0; n<4; n++) {
						int nr = i + dr[n];
						int nc = j + dc[n];
						if(nr >=0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '*') {
							check++;
						}
					}
					if(check == 4) {
						//심장의 위치
						hr = i;
						hc = j;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(hr+1).append(" ").append(hc+1).append("\n");

		int waist = countWaist(map, hr, hc);
		int lHand = countLHand(map, hr, hc);
		int rHand = countRHand(map, hr, hc);
		int lLeg = countLLeg(map, wr, wc);
		int rLeg = countRLeg(map, wr, wc);
		
		sb.append(lHand).append(" ").append(rHand).append(" ").append(waist).append(" ").append(lLeg).append(" ").append(rLeg);
		
		System.out.println(sb);
	}
	
	static int countWaist(char[][] map, int r, int c) {
		int cnt = 0;
		
		while(r < N && c < N && map[r][c] == '*') {
			r++;
			cnt++;
		}
		

		wr = r-1;
		wc = c;
		
		return cnt-1;
	}
	
	static int countLHand(char[][] map, int r, int c) {
		int cnt = 0;
		
		while(r < N && c >= 0 && map[r][c] == '*') {
			c--;
			cnt++;
		}
		

	
		return cnt-1;
	}
	
	static int countRHand(char[][] map, int r, int c) {
		int cnt = 0;
		
		while(r < N && c < N && map[r][c] == '*') {
			c++;
			cnt++;
		}
		
		
		return cnt-1;
	}
	
	static int countLLeg(char[][] map, int r, int c) {
		int cnt = 0;
		
		while(r+1 < N && c-1 >= 0 && map[r+1][c-1] == '*') {
			r++;
			cnt++;
		}
		
		return cnt;
	}

	static int countRLeg(char[][] map, int r, int c) {
		int cnt = 0;
		
		while(r+1 < N && c+1 < N && map[r+1][c+1] == '*') {
			r++;
			cnt++;
		}
		
		return cnt;
	}	
	
}
