package Baekjoon.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2108_통계학 {
    public static double arith_mean(int[] nums) {       //산술평균
        double res = 0.0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        res /= nums.length;

        return Math.round(res);
    }

    public static int median(int[] nums) {  //중앙값
        Arrays.sort(nums);

        return (nums[nums.length / 2]);
    }

    public static int mode(int[] nums) {    //최빈값
        int[] count = new int[8001];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }


        int num = 0;
        int mode = 0;
        boolean check = false;

        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 4000]++;
        }

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (count[i] > num) {
                num = count[i];
                mode = i - 4000;
                check = true;
            } else if (count[i] == num && check == true) {
                mode = i - 4000;
                check = false;
            }
        }

        return mode;
    }

    public static int range(int[] nums) {  //범위
        Arrays.sort(nums);

        return nums[nums.length - 1] - nums[0];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println((int) arith_mean(nums));
        System.out.println(median(nums));
        System.out.println(mode(nums));
        System.out.println(range(nums));

    }
}
