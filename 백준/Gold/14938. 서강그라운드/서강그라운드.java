import java.util.*;

public class Main {
	static final int INF = (int) 1e9;
	static int n, m, r;
	static int[][] dist;
	static int[] item;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		
		dist = new int[n+1][n+1];
		item = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		for(int i=1; i<n+1; i++) item[i] = sc.nextInt();
		
		for(int i=0; i<r; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int l = sc.nextInt();
			
//			dist[a][b] = Math.min(dist[a][b], l);
//			dist[b][a] = Math.min(dist[b][a], l);
			dist[a][b] = l;
			dist[b][a] = l;
		}
		
		floyd();
		
		
		int maxItem = 0;
		for(int s=1; s<n+1; s++) {
			int getItem = 0;
			for(int e=1; e<n+1; e++) {
				if(dist[s][e] <= m) getItem += item[e];
			}
			
			maxItem = Math.max(maxItem, getItem);
		}
		
		System.out.println(maxItem);
	}

	static void floyd() {
		for(int w=1; w<n+1; w++) {
			for(int s=1; s<n+1; s++) {
				if(s == w || dist[s][w] == INF) continue;
				for(int e=1; e<n+1; e++) {
					if(w == e || dist[w][e] == INF) continue;
					dist[s][e] = Math.min(dist[s][e], dist[s][w] + dist[w][e]);
				}
			}
		}
	}
}
