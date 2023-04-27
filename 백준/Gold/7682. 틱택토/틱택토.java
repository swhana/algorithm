import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int rowCntX, rowCntO, colCntX, colCntO, crsCntX, crsCntO;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			int cntX = 0;
			int cntO = 0;
			rowCntX = 0;
			rowCntO = 0;
			colCntX = 0;
			colCntO = 0;
			crsCntX = 0;
			crsCntO = 0;

			if (str.equals("end")) {
				break;
			}

			map = new char[3][3];

			int idx = 0;
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					map[r][c] = str.charAt(idx);
					idx++;
					if(map[r][c] == 'X') cntX++;
					else if(map[r][c] == 'O') cntO++;
				}
			}

			if (Math.abs(cntX - cntO) > 1 || cntO > cntX) {
				System.out.println("invalid");
				continue;
			}

			// 세로줄 체크
			for (int i = 0; i < 3; i++) {
				int colX = 0;
				int colO = 0;
				for (int j = 0; j < 3; j++) {
					if (map[j][i] == 'X')
						colX++;
					else if (map[j][i] == 'O')
						colO++;
				}
				if (colX == 3) {
					colCntX++;
				}
				else if (colO == 3) {
					colCntO++;
				}
			}

			// 가로줄 체크
			for (int i = 0; i < 3; i++) {
				int rowX = 0;
				int rowO = 0;
				for (int j = 0; j < 3; j++) {
					if (map[i][j] == 'X')
						rowX++;
					else if (map[i][j] == 'O')
						rowO++;
				}
				if (rowX == 3) {
					rowCntX++;
				}
				else if (rowO == 3) {
					rowCntO++;
				}
			}

			
			if (map[0][0] == map[1][1] && map[0][0] == map[2][2]) {
				if (map[1][1] == 'X')
					crsCntX++;
				else if (map[1][1] == 'O')
					crsCntO++;
			}
			if (map[0][2] == map[1][1] && map[0][2] == map[2][0]) {
				if (map[1][1] == 'X')
					crsCntX++;
				else if (map[1][1] == 'O')
					crsCntO++;
			}

			
			///////////////
			if (colCntX > 1 || colCntO > 1 || rowCntX > 1 || rowCntO > 1) {
				System.out.println("invalid");
				continue;
			}
			// O의 승리
			if (cntX == cntO) {
				if (rowCntX > 0 || colCntX > 0 || crsCntX > 0) {
					System.out.println("invalid");
					continue;
				}
			}

			// X의 승리
			else if (cntX == cntO + 1) {
				if (rowCntO > 0 || colCntO > 0 || crsCntO > 0) {
					System.out.println("invalid");
					continue;
				}
			}
			
			if (cntX + cntO == 9) {
				System.out.println("valid");
				continue;
			}
			
			if (rowCntX + rowCntO + colCntX + colCntO + crsCntX + crsCntO == 0) {
				System.out.println("invalid");
				continue;
			}


			System.out.println("valid");
		}
	}

}
