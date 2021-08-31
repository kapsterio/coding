package com.zh.dp;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */
public class LIS {
    /**
     * 定义
     * 先尝试 dp[i]: nums[0..i]的LIS长度，显然不好写出递推式
     * 再尝试 dp[i]: nums[0..i]的以num[i]为最后一个元素的LIS长度，这样一来
     * dp[i] = Max {dp[j] + 1 |  0 <= j <= i -1   && nums[i] > nums[j]}
     *
     * 原问题：Max {dp[i] | 0 <= i <= m-1}
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) { //如果所有的nums[j]都比nums[i]大，那么dp[i]就是1，也就是
                    if (dp[j] + 1 > max) {
                        max = dp[j] + 1;
                    }
                }
            }
            dp[i] = max;
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
