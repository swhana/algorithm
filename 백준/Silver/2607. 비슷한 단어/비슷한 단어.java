import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] origin = br.readLine().split(""); //비교할 원본단어
		
		int answer = 0; //비슷한 단어 세기
		
		for(int i=1; i<N; i++) {
			int cnt = 0; //얼마나 비슷한치 체크
			String[] str = br.readLine().split("");
			boolean[] visited = new boolean[str.length];
			for(int j=0; j<origin.length; j++) {
				for(int k=0; k<str.length; k++) {
					if(origin[j].equals(str[k]) && !visited[k]) {
						visited[k] = true;
						cnt++;
						break;
					}
				}
			}
			if(str.length == origin.length - 1 && cnt == str.length) answer++; //하나 빼기
			else if(str.length == origin.length && cnt == str.length) answer++; //같은 구성
			else if(str.length == origin.length && cnt == str.length - 1) answer++; //하나 바꾸기
			else if(str.length == origin.length + 1 && cnt == str.length - 1) answer++; //하나 더하기
		}
		
		System.out.println(answer);
	}

}
