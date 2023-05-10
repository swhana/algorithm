import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> keywordMap = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			keywordMap.put(input, 1);
		}
		
		int total = N;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while(st.hasMoreTokens()) {
				String keyword = st.nextToken();
				if(keywordMap.getOrDefault(keyword, 0) == 1) {
					keywordMap.replace(keyword, 0);
					total--; //키워드를 제거
				}
			}
			System.out.println(total);
		}
	}
}
