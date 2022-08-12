import java.util.Scanner;

//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt();
//
//		int[] arr = new int[N];
//
//		for (int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//		}
//
//		// 시작하는 수 그 자체로 수열 하나가 되기 때문에 초기화값은 0이 아닌 1로
//		int count_up = 1; // 오름차순 카운트
//		int max_count_up = 1; // 오름차순이 끊겼을 경우 저장할 위치
//		int count_down = 1; // 내림차순 카운트
//		int max_count_down = 1; // 내림차순이 끊겼을 경우 저장할 위치
//
//		for (int i = 0; i < N - 1; i++) {
//			// 오름차순 판별
//			if (arr[i] < arr[i + 1]) {
//				count_up++;
//				// 내림차순은 끊겼으므로 값을 변수에 따로 저장하고 초기화
//				max_count_down = Math.max(max_count_down, count_down);
//				count_down = 1;
//			} else if (arr[i] > arr[i + 1]) {
//				// 오름차순이 끊겼으므로 값을 변수에 따로 저장하고 초기화
//				max_count_up = Math.max(max_count_up, count_up);
//				count_up = 1;
//				count_down++;
//			}
//			// 두 수가 같은 경우는 오름차순 내림차순 둘다 가능
//			else {
//				count_up++;
//				count_down++;
//			}
//		}
//		// 오름차순이나 내림차순이 끊기지 않았을 경우에는 따로 계산해줘야한다
//		max_count_up = Math.max(max_count_up, count_up);
//		max_count_down = Math.max(max_count_down, count_down);
//
//		System.out.println(Math.max(max_count_up, max_count_down));
//	}
//
//}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = 1, cnt1 = 1, cnt2 = 1, max = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				if (arr[i - 1] == arr[i]) {
					cnt1++;
					cnt2++;

				} else if (arr[i - 1] < arr[i]) {

					cnt2 = 1;

					cnt1++;
					d = 1;
				} else if (arr[i - 1] > arr[i]) {

					cnt1 = 1;

					cnt2++;
					d = 2;
				}
			}
			if (max < (cnt1 > cnt2 ? cnt1 : cnt2)) {
				max = (cnt1 > cnt2 ? cnt1 : cnt2);
			}
		}
		System.out.println(max);
		sc.close();
	}
}