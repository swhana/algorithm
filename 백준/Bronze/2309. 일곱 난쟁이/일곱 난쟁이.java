import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] nums = new int[9];

		int total = 0;
		for (int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
			total += nums[i];
		}
		Arrays.sort(nums);
		int newtotal;

		int x = 0;
		int y = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				newtotal = total - nums[i] - nums[j];
				if (newtotal == 100) {
					x = i;
					y = j;
					break;
				}

			}
		}

		for (int i = 0; i < 9; i++) {
			if (i != x && i != y)
				System.out.println(nums[i]);
		}

	}

}