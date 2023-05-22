import java.util.*;

public class Main {
	static LinkedList<Integer>[] adjList;
	static boolean[] visited;
	static StringBuilder sb;
	
	static void dfs(int node) {
		if(visited[node]) return;
		visited[node] = true;
		sb.append(node + " ");
		
		for(int next : adjList[node]) {
			dfs(next);
		}
	}
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		visited[node] = true;
		q.add(node);
		
		while(!q.isEmpty()) {
			int n = q.poll();
			sb.append(n + " ");
			
			for(int next: adjList[n]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //정점 개수
		int M = sc.nextInt(); //간선 개수
		int V = sc.nextInt(); //시작 정점
		
		adjList = new LinkedList[N+1];
		for(int i=0; i<N+1; i++) adjList[i] = new LinkedList<Integer>();
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			//양방향 간선이기 때문에 양쪽 인접 리스트에 다 추가
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		for(int i=1; i<N+1; i++) Collections.sort(adjList[i]);
		
		
		dfs(V);
		System.out.println(sb);
		
		
		visited = new boolean[N+1];
		sb = new StringBuilder();
		bfs(V);
		System.out.println(sb);
	}

}
