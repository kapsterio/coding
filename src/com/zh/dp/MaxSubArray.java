package com.zh.dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaxSubArray {

    /**
     * 定义：dp[i]: num[0...i]中以num[i]结尾的最大连续子数组
     * dp[i]  = d[i-1] + num[i], if d[i-1] > 0
     * dp[i] = num[i] if d[i-1] <=0
     *
     * 原问题： max {dp[j], 0<= j < m}
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i ++) {
            dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i];
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
