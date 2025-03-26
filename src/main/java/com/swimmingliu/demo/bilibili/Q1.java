package com.swimmingliu.demo.bilibili;


import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

    private static int findAnswer(int n, int k, int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        int res = 0;
        while (k > 0 && left < right) {
            res += nums[right] - nums[left];
            k--;
            left++;
            right--;
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i ++) nums[i] = in.nextInt();
        int n = 5, k = 3;
        int[] nums = {0 , 0, 0, 1, 1, 1};
        System.out.println(findAnswer(n, k, nums));
    }
}
