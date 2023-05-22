import java.util.*;
import java.io.*;

public class Main {
	static LinkedList<Character> str = new LinkedList<>();
	static Stack<Character> temp = new Stack<>();

	static void cursorLeft() {
		if(str.isEmpty()) return;
		temp.push(str.pollLast());
	}

	static void cursorRight() {
		if(temp.isEmpty()) return;
		str.addLast(temp.pop());
	}

	static void deleteWord() {
		if(str.isEmpty()) return;
		str.pollLast();
	}

	static void addWord(Character word) {
		str.addLast(word);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String input = br.readLine();

		for (int i = 0; i < input.length(); i++)
			str.addLast(input.charAt(i));
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			String command = st.nextToken();


			switch (command) {
			case "L":
				cursorLeft();
				break;
			case "D":
				cursorRight();
				break;
			case "B":
				deleteWord();
				break;
			case "P":
				addWord(st.nextToken().charAt(0));
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		while(!str.isEmpty()) sb.append(str.poll());
		while(!temp.isEmpty()) sb.append(temp.pop());
		
		System.out.println(sb);
		
	}

}
