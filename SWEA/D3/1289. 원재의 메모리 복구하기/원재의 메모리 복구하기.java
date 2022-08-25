import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int k = 1; k <= tc; k++) {
            String input = sc.next();

            int[] arr = new int[input.length()];
            for (int i = 0; i < input.length(); i++) {
                arr[i] = input.charAt(i) - '0';
            }

            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    int j = i;
                    while (j < arr.length) {
                        if (arr[j] == 1)
                            arr[j] = 0;
                        else
                            arr[j] = 1;
                        j++;
                    }
                    cnt++;
                }

            }

            System.out.println("#" + k + " " + cnt);
        }

    }
}