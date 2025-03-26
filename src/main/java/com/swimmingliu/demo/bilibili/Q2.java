package com.swimmingliu.demo.bilibili;


import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

    private static int findAnswer(int n, int m, int k) {
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        int useful = m - n;
        int res = nums[k];
        while(useful > 0){
            nums[k] += 1;
            useful --;
            useful = adjust(nums, k, useful);
            if (useful >= 0) res = nums[k];
        }
        return res;
    }
    private static int adjust(int[] nums, int k, int useful){
        if (useful <= 0 || k < 0 || k >= nums.length) return useful;
        if (k - 1 >= 0 && nums[k] - nums[k - 1] > 1){ // 左边
            nums[k - 1] += 1;
            useful --;
            adjust(nums, k - 1, useful);
        }
        if (k + 1 < nums.length && nums[k] - nums[k + 1] > 1){ // 右边
            nums[k + 1] += 1;
            useful --;
            adjust(nums, k + 1, useful);
        }
        return useful;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int k = in.nextInt();
        int n = 18, m = 99, k = 17;
        System.out.println(findAnswer(n, m, k - 1));
    }
}
