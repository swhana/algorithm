import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int[] ans = new int[N];
		
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		
		for(int i=0; i<N; i++) {
			//arr[i]
			int cnt = 0;
			int idx = 0;
			while(cnt <= arr[i]) {
				if(ans[idx] == 0) {
					cnt++;
				}
				idx++;
			}
			ans[idx-1] = i+1;
		}
		
		for(int i=0; i<N; i++) System.out.print(ans[i] + " ");

	}

}
