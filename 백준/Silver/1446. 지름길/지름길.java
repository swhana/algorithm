import java.util.*;

public class Main {
	static int[] dp; //해당 길이를 최소로 갈수 있는 거리 저장배열 dp[]
	static List<Node>[] shortcutList;
	
	static class Node {
		int from;
		int dist;
		
		public Node (int from, int dist) {
			this.from = from;
			this.dist = dist;
		}
	}
	
	//n까지 갈때 최소거리 dp를 찾는 함수
	static int findDP(int n) {
		if(n == 0) return 0;
		if(dp[n] != 0) return dp[n]; //이미 한번 지름길 계산이 끝난 상태라면 그대로 계산값을 리턴하고 끝
		
		dp[n] = findDP(n-1) + 1; //기본거리

		if(shortcutList[n].size() > 0) {
			for(Node shortcut : shortcutList[n]) {
				dp[n] = Math.min(dp[n], findDP(shortcut.from) + shortcut.dist);
			}
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //지름길의 개수 N
		int D = sc.nextInt(); //고속도로의 길이 D
		
		dp = new int[D+1];
		shortcutList = new ArrayList[10001]; //각 도착지 정보에 대해 지름길 정보를 담은 리스트 생성
		
		for(int i=0; i<10001; i++) shortcutList[i] = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int from = sc.nextInt(); //출발지
			int to = sc.nextInt(); //도착지
			int dist = sc.nextInt(); //거리
			
			//도착지의 연결리스트에 from과 dist 정보를 추가
			//우선 지름길이 맞는지부터 확인한 후
			if(to - from > dist) {
				shortcutList[to].add(new Node(from, dist));
			}
		}
		
		System.out.println(findDP(D));
	}

}
