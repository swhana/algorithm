import java.util.*;

public class Main {
	static int N, M;
	static boolean[][] visited;
	
	static class Node {
		int r;
		int c;
		
		public Node (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	static void bfs(int[][] map, int r, int c) {
		Queue<Node> q = new LinkedList<>();
		map[r][c] = 0;
		q.add(new Node(r, c));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.r+1 < N && map[n.r+1][n.c] == 1 && !visited[n.r+1][n.c]) {
				map[n.r+1][n.c] = map[n.r][n.c] + 1;
				visited[n.r+1][n.c] = true;
				q.add(new Node(n.r+1, n.c));
			}
			if(n.c+1 < M && map[n.r][n.c+1] == 1 && !visited[n.r][n.c+1]) {
				map[n.r][n.c+1] = map[n.r][n.c] + 1;
				visited[n.r][n.c+1] = true;
				q.add(new Node(n.r, n.c+1));
			}
			
			if(n.r-1 >= 0 && map[n.r-1][n.c] == 1 && !visited[n.r-1][n.c]) {
				map[n.r-1][n.c] = map[n.r][n.c] + 1;
				visited[n.r-1][n.c] = true;
				q.add(new Node(n.r-1, n.c));
			}
			
			if(n.c-1 >= 0 && map[n.r][n.c-1] == 1 && !visited[n.r][n.c-1]) {
				map[n.r][n.c-1] = map[n.r][n.c] + 1;
				visited[n.r][n.c-1] = true;
				q.add(new Node(n.r, n.c-1));
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[][] map = new int[N][M];
		visited = new boolean[N][M];
		
		int r = 0, c = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					r = i;
					c = j;
				}
			}
		}
		
		bfs(map, r, c);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 1) sb.append(map[i][j] + " ");
				else if(!visited[i][j]) sb.append(-1 + " ");
				else sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
