import java.util.*;

public class Main {
	static int[] building;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		building = new int[N];
		
		int[] canSee = new int[N];
		
		for(int i=0; i<N; i++) building[i] = sc.nextInt();
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				double originDegree = degree(i, j);
			
				boolean check = false;
				for(int k=i+1; k<j; k++) {
					if(degree(i, k) >= originDegree) {
						check = true;
					}
				}
				
				if(!check) {
					canSee[i]++;
					canSee[j]++;
				}				
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<canSee.length; i++) {
			max = Math.max(max, canSee[i]);
		}
		System.out.println(max);
			
	}

	static double degree(int x, int y) {
		return (double)(building[x] - building[y])/(x-y);
	}
}
