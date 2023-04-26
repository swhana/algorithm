import java.util.*;

public class Main {
	static class Node {
		int score;
		int rank;
		
		public Node(int score) {
			this.score = score;
			this.rank = 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //초기 입력 길이
		int S = sc.nextInt(); //새로운 점수
		int P = sc.nextInt(); //리스트 길이
		
		
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new Node(sc.nextInt()));
		}
		
		if(list.size() >= P && list.get(P-1).score >= S) {
			System.out.println(-1);
			return;
		}
		list.add(new Node(S));
		
		Collections.sort(list, (o1, o2) -> {
			return o2.score - o1.score;
		});
		
		int myRank = 1;
		int cnt = 0;
		for(Node n : list) {
			if(n.score > S) {
				myRank++;
			}
			else if(n.score == S) {
				cnt++;
			}
		}

		if(myRank == P && cnt > 1) {
			myRank = -1;
		}
		if(myRank > P || cnt > P) myRank = -1;

		
		System.out.println(myRank);
	}
}
