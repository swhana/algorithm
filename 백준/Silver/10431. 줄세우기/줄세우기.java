import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();
		
		for(int tc=0; tc<P; tc++) {
			int T = sc.nextInt();
			int[] arr = new int[20];
			for(int i=0; i<20; i++) {
				arr[i] = sc.nextInt();
			}
			
			int cnt = 0;
			for(int i=1; i<20; i++) {
				//arr[i]가 기준
				//비교대상 순회
				int idx = i;
				while(idx > 0) {
					for(int j=idx-1; j>=0; j--) {
						if(arr[j] > arr[idx]) {
							int temp = arr[j];
							arr[j] = arr[idx];
							arr[idx] = temp;
							cnt++;
						}
					}
					idx--;
				}

			}
			
			System.out.println(tc+1 + " " + cnt);
		}
	}

}
