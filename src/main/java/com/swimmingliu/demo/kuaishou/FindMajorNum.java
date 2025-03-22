package com.swimmingliu.demo.kuaishou;

import java.util.Scanner;

/**
 * - 给定已排序且长度为 `N` 的数组 (元素可重复)
 * 请你找出出现次数超过 `N/2` 的元素 （答案可以不唯一）
 * 要求时间复杂度为 `o (logN)`
 * 例如：
 * - [1, 2, 2, 3, 3, 3] -> 3
 * - [2, 2, 2, 3, 3, 3] -> 2 或者 3
 */
public class FindMajorNum {

    private static void readNums() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
            }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 分成奇数和偶数来进行确定，如果是奇数，一定是最中间的元素
    // 如果是偶数，则需要判断最中间的两个数，采用二分查找进行判断
    private static int findMajorNum(int[] nums){
        int length = nums.length;
        if (length % 2 != 0) return nums[length / 2];
        int numLeft = nums[length / 2];
        int numRight = nums[length / 2 + 1];
        int start = findFirst(numLeft, nums, 0, numLeft - 1);
        int end = findLast(numLeft, nums, numLeft + 1, length);
        if(end - start + 1 >= length / 2) return numLeft;
        else return numRight;
    }

    private static int findFirst(int x, int[] nums, int left, int right){
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= x) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private static int findLast(int x, int[] nums, int left, int right){
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] <= x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3, 3, 3};
        int res = findMajorNum(nums);
        System.out.println(res);
    }
}
