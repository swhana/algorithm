import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		int M = sc.nextInt();
		
		Arrays.sort(arr);
		
		int lo = 0;
		int hi = arr[N-1];
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			
			int sum = 0;
			for(int i=0; i<N ;i++) {
				if(arr[i] <= mid) sum += arr[i];
				else sum += mid;
			}
			if(sum < M) lo = mid + 1;
			else if(sum > M) hi = mid - 1;
			else {
				hi = mid;
				break;
			}
		}
	
		System.out.println(hi);
	}

}
