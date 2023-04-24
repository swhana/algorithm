import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			String[] ch = str.split(" ");
			String comm = ch[0];
			int input = -1;
			if(ch.length > 1) input = Integer.parseInt(ch[1]);
			
			switch(comm) {
				case "add": {
					map.putIfAbsent(input, 1);
					break;
				}
				case "remove": {
					if(map.get(input) != null) map.remove(input);
					break;
				}
				case "check": {
					if(map.get(input) != null) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				}
				case "toggle": {
					if(map.get(input) != null) {
						map.remove(input);
					} else map.put(input, 1);
					break;
				}
				case "all": {
					for(int idx=1; idx<=20; idx++) {
						map.put(idx, 1);
					}
					break;
				}
				case "empty": {
					for(int idx=1; idx<=20; idx++) {
						map.remove(idx);
					}
					break;
				}
			}
		}
		
		System.out.println(sb);
	}

}
