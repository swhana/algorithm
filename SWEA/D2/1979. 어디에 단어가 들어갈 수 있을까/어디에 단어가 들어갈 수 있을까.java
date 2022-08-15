import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스
		for (int k = 1; k <= T; k++) {

			int N = sc.nextInt(); // 퍼즐 크기 N*N
			int K = sc.nextInt(); // 단어 길이 K

			int[][] puzzle = new int[N][N];

			int res = 0;
			int cnt1 = 0;	//가로 카운터
			int cnt2 = 0;	//세로 카운터
			
			for (int i = 0; i < N; i++) { // 퍼즐 모양 입력받기
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				cnt1 = 0;
				cnt2 = 0;
				for (int j = 0; j < N; j++) {
					if(puzzle[i][j]==1) ++cnt1;		// 가로부터 입력이 1 나오면 카운터 1
					else cnt1=0;				// 입력이 0 나오면 카운터 초기화
					if(cnt1==K)	res++;	// 매 가로줄마다 정산해서 카운터가 K랑 같으면 결과값 +1
					if(cnt1==K+1) res--;	// K+1도 연속해서 1이면 그 전에 기록했던 결과가 무의미 해지므로 1 빼줘야함
								
					if(puzzle[j][i]==1) ++cnt2;		// 세로편
					else cnt2=0;
					if(cnt2==K)	res++;
					if(cnt2==K+1) res--;
				}
			}
			System.out.println("#" + k + " " + res);
		}	
		sc.close();
	}
}