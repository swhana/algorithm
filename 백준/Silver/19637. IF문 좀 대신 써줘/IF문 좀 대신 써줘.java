import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] title = new String[N];
		int[] power = new int[N];
		
		//N도 10^5까지 범위
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			title[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		int lp, rp;
		
		//입력받은 자리에서 처리
		for(int i=0; i<M; i++) {
			int input = Integer.parseInt(br.readLine());
			
			lp = 0;
			rp = N-1;
			
			while(lp <= rp) {
				int cp = (lp + rp) / 2;
				
				//input은 최소 title[cp]의 칭호는 확보하게 되는것
				if(input <= power[cp]) rp = cp - 1;
				//더 높은 칭호가 있는지 찾기 위해 lp를 cp 이상의 인덱스로 옮긴다
				else lp = cp + 1;
			}
			sb.append(title[lp]).append("\n");
		}
		
		System.out.println(sb);
	}
}
