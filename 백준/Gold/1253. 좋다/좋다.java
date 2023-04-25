import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = 0; //좋은 수의 개수
		for(int i=0; i<N; i++) {
			int left = 0;
			int right = N-1;
			//arr[i]를 기준으로 투포인터 돌면서 arr[i]를 만들 수 있는지 확인
			//먼저 hashmap에서 1이 되어있으면 이미 한번 체크한 수이므로 스킵
			//불가능한 경우 hashmap에 2로 넣어서 그것도 스킵
			
			int isChecked = map.getOrDefault(arr[i], 0);
			if(isChecked == 0) {
				boolean check = false;
				while(left < right) {
					if(left != i && right != i) {
						if(arr[left] + arr[right] > arr[i]) {
							right--;
						} else if(arr[left] + arr[right] < arr[i]) {
							left++;
						} else {
							cnt++;
							map.putIfAbsent(arr[i], 1);
							check = true;
							break;
						}
					} else if(left == i) {
						left++;
					} else if(right == i) {
						right--;
					}

				}
				if(!check) map.put(arr[i], 2);
			}
			else if(isChecked == 1) {
				cnt++;
				continue;
			} else {
				continue;
			}
		}
		
		System.out.println(cnt);
	}

}
