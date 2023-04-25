import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int N = Integer.parseInt(input.split(" ")[0]);
		String game = input.split(" ")[1];
		
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			set.add(name);
		}
		
		if(game.equals("Y")) System.out.println(set.size());
		else if(game.equals("F")) System.out.println(set.size()/2);
		else System.out.println(set.size()/3);
		
		return;
	}

}
