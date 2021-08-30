package com.zh.sliding_window;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int window = 0;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            window += nums[right];
            right ++;
            while (window >= target) {
                //缩小窗口
                if (right - left < min) {
                    min = right - left;
                }
                window -= nums[left];
                left ++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
