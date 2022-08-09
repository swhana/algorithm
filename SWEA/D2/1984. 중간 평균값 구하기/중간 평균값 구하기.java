import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for(int k=1; k<=tc; k++){
            int[] arr = new int[10];

            for(int i=0; i<10; i++)
                arr[i] = sc.nextInt();


            Arrays.sort(arr);

            double avg = 0;
            for(int i=1; i<9; i++)
                avg += arr[i];

            avg /= 8;

            System.out.println("#" + k + " " + String.format("%.0f", avg));
        }
    }
}