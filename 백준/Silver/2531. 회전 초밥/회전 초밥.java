import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 접시의 수 N
		int d = sc.nextInt(); // 초밥의 가짓수 d
		int k = sc.nextInt(); // 연속해서 먹는 접시의 수 k
		int c = sc.nextInt(); // 쿠폰 번호 c

		int[] dish = new int[N + k];

		for (int i = 0; i < N; i++) {
			dish[i] = sc.nextInt();
		}

		for (int i = N; i < N + k; i++) {
			dish[i] = dish[i - N];
		}

		int lp = 0;
		int rp = k - 1;
		int max = Integer.MIN_VALUE;

		HashMap<Integer, Integer> map = new HashMap<>();

		map.put(c, map.getOrDefault(c, 0) + 1);
		for (int i = lp; i <= rp; i++) {
			map.put(dish[i], map.getOrDefault(dish[i], 0) + 1);
		}

		max = Math.max(max, map.size());

		while (rp < N + k) {
			if (rp == k - 1) {
				rp++;
				continue;
			}
			// 추가하려는 값이 없을 경우

			map.put(dish[rp], map.getOrDefault(dish[rp], 0) + 1);
			
			map.put(dish[lp], map.get(dish[lp]) - 1);
			if (map.get(dish[lp]) == 0)
				map.remove(dish[lp]);
			
			max = Math.max(max, map.size());

			lp++;
			rp++;
		}
		System.out.println(max);
	}

}
