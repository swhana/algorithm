import java.util.*;
import java.io.*;

public class Main {

	// 결과적으로는 aaaaaa..aabbbbb..bb의 문자열이 만들어져야한다
	// 즉 a의 개수만큼의 문자열길이를 이동하면서 체크하고 그 안의 b개수만큼 교환해주면 필요한 교환의 횟수가 구해진다

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int a = 0;
		
		for(int i=0; i<input.length(); i++) if(input.charAt(i) == 'a') a++;
		
		int lp = 0;
		int rp = a;
		
		int min = Integer.MAX_VALUE;
		while(rp <= input.length() + a) {
			int cnt = 0;
			for(int i=lp; i<rp; i++) {
				if(i<input.length() && input.charAt(i) == 'b') cnt++;
				if(i>=input.length() && input.charAt(i-input.length()) == 'b') cnt++;
			}
			lp++;
			rp++;
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
	}

}
