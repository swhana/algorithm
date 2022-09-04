import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int k = 1; k <= T; k++) {
			int x1, y1, r1, x2, y2, r2 = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			double dis = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

			// 두 원의 중심이 일치할때
			if (x1 == x2 && y1 == y2) {
				if (r1 == r2) {
					// 두 원이 모두 점으로 일치할 때
					if (r1 == 0)
						System.out.println(1);
					// 두 원이 완전히 일치할 때
					else
						System.out.println(-1);
				}
				// 중심만 일치하고 반지름이 다를 때
				else
					System.out.println(0);
			}
			// 그 외
			else {
				// 외접원
				if (dis == r1 + r2)
					System.out.println(1);
				// 두 원이 만나지 않을 때
				else if (dis > r1 + r2)
					System.out.println(0);
				// 두 원이 교차할 때
				else if (dis < r1 + r2) {
					// 한쪽 원이 다른 원을 포함할 때
					if (r1 > r2 + dis)
						System.out.println(0);
					else if (r2 > r1 + dis)
						System.out.println(0);
					// 내접원
					else if (r1 == dis + r2)
						System.out.println(1);
					else if (r2 == dis + r1)
						System.out.println(1);
					// 그 외
					else
						System.out.println(2);
				}
			}
		}
	}
}