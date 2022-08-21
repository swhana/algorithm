import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 참외 수
		int K = sc.nextInt();

		int[][] dir_dis = new int[6][2];

		for (int i = 0; i < 6; i++) {
			dir_dis[i][0] = sc.nextInt(); // 방향
			dir_dis[i][1] = sc.nextInt(); // 길이
		}

		int max_length = 0;
		int max_height = 0;

		// 가로세로 최대길이 구하기
		for (int i = 0; i < 6; i++) {
			if (dir_dis[i][0] == 1 || dir_dis[i][0] == 2) { // 동 또는 서 방향
				if (max_length < dir_dis[i][1])
					max_length = dir_dis[i][1];
			}

			if (dir_dis[i][0] == 3 || dir_dis[i][0] == 4) { // 남 또는 북 방향
				if (max_height < dir_dis[i][1])
					max_height = dir_dis[i][1];
			}
		}

		int sum = 0;

		// 인접한 변끼리의 곱 구하기
		for (int i = 0; i < 6; i++) {
			if (i < 5)
				sum += dir_dis[i][1] * dir_dis[i + 1][1];
			else if (i == 5)
				sum += dir_dis[i][1] * dir_dis[0][1];
		}

		// 인접한 변끼리의 곱 - 전체넓이*2 = 구하려는 넓이
		sum -= 2 * max_length * max_height;

		System.out.println(sum * K);
	}
}