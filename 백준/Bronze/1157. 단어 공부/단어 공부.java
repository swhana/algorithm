import java.util.*;

public class Main {
	static class Node {
		int idx;
		int cnt;
		
		public Node(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int[] cnt = new int[123];
		
		for(int i=0; i<str.length(); i++) {
			int ch = str.charAt(i);
			if(ch >= 65 && ch < 91) cnt[ch]++;
			else if(ch >= 97 && ch < 123) cnt[ch-32]++;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);
		
		for(int i=65; i<97; i++) pq.add(new Node(i, cnt[i]));
		
		Node n = pq.poll();
		char max = (char)n.idx;
		if(!pq.isEmpty() && pq.peek().cnt == n.cnt) max = '?';
		System.out.println(max);
	}

}
