import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] balls = br.readLine().toCharArray();
		char start = balls[N-1];
		
		
		int rCnt = 0;
		int bCnt = 0;
		
		for(char ball : balls) {
			if(ball == 'R') rCnt++;
			else bCnt++;
		}
		
		
		int i = 1;
		while(N-1-i >= 0 && balls[N-1-i] == start) {
			i++;
		}
		

		if(start == 'R') System.out.println(rCnt-i < bCnt ? rCnt-i : bCnt);
		else System.out.println(rCnt < bCnt-i ? rCnt : bCnt-i);
	}

}
