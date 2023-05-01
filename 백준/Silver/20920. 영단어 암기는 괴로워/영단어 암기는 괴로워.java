import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String firstLine = br.readLine();
		int N = Integer.parseInt(firstLine.split(" ")[0]);
		int M = Integer.parseInt(firstLine.split(" ")[1]);
		
		
		//빈도 체크를 위한 해시맵
		HashMap<String, Integer> wordMap = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
			int freq1 = wordMap.getOrDefault(o1, 0); //단어 o1의 출현빈도
			int freq2 = wordMap.getOrDefault(o2, 0); //단어 o2의 출현빈도
			
			if(freq1 < freq2) return 1;
			else if(freq1 > freq2) return -1;
			else {
				if(o1.length() < o2.length()) return 1;
				else if(o1.length() > o2.length()) return -1;
				else {
					int i = 0;
					while(o1.length() > i && o2.length() > i) {
						if(o1.charAt(i) > o2.charAt(i)) return 1;
						else if(o1.charAt(i) < o2.charAt(i)) return -1;
						else i++;
					}
				}
			}
			
			return 0;
		});
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(input.length() >= M) {
				wordMap.put(input, wordMap.getOrDefault(input, 0) + 1);
			}
		}
		
		for(String str : wordMap.keySet()) {
			pq.add(str);
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);
	}

}
