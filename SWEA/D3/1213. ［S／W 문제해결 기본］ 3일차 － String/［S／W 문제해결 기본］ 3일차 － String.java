import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int k = 1; k <= 10; k++) {
			int tc = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String list = br.readLine();

			int cnt = 0;
//			while (list.contains(input)) {
//				list = list.substring(list.indexOf(input));
//				cnt++;
//			}

			for (int i = 0; i <= list.length() - input.length(); i++) {
				if (list.substring(i, i + input.length()).equals(input))
					cnt++;
			}

			StringBuilder sb = new StringBuilder();

			sb.append("#" + tc + " " + cnt);

			System.out.println(sb);
		}

	}

}