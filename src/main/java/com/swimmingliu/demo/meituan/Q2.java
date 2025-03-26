package com.swimmingliu.demo.meituan;


import java.util.Scanner;

public class Q2 {
    // 好数组：未排序数组，如果长度是奇数，中间的数正好是中位数。 例如 2， 1， 3， 5， 4
    // 求解：找出给出的多个数组当中，每个数组里面有多少个好数组
    private static int findAnswer(int[][] nums){
        int n = nums.length;
        int m = nums[0].length;
        int res = nums.length * nums[0].length;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){

            }
        }
        return res;
    }
    private static boolean isValid(int[] nums, int start, int end){
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] nums = new int[n][m];
        System.out.println(findAnswer(nums));
    }
}
