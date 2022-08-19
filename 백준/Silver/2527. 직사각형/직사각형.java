import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[4][8];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 4; i++) {
			int a0 = arr[i][0];
			int a1 = arr[i][1];
			int a2 = arr[i][2];
			int a3 = arr[i][3];
			int b0 = arr[i][4];
			int b1 = arr[i][5];
			int b2 = arr[i][6];
			int b3 = arr[i][7];

			if ((a0 == b2 && a1 == b3) || (a0 == b2 && a3 == b1) || (a2 == b0 && a3 == b1) || (a2 == b0 && a1 == b3)) {
				System.out.println("c");
			} else if (a2 < b0 || a0 > b2 || a1 > b3 || a3 < b1)
				System.out.println("d");
			else if ((a0 == b2) || (a2 == b0) || (a1 == b3) || (a3 == b1))
				System.out.println("b");

			else
				System.out.println("a");
		}
	}

}