import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        char[] arr1 = new char[str1.length()];
        char[] arr2 = new char[str2.length()];

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length(); i++) arr1[i] = str1.charAt(i);
        for (int i = 0; i < str2.length(); i++) arr2[i] = str2.charAt(i);

        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }


        System.out.println(dp[str1.length()][str2.length()]);

    }

}