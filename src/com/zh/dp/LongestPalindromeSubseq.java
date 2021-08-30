package com.zh.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 */
public class LongestPalindromeSubseq {
    /**
     * 问题定义
     * dp[i, j]: s中从i到j的最长回文子序列的长度，i <= j
     * dp[i, j] = dp[i+1, j-1] + 2, if s[i] = s[j]
     * dp[i, j] = max {dp[i+1, j], dp[i, j-1]}
     *
     * 原问题dp[0, s.length -1]
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int col = 0; col < s.length(); col++) {
            for (int row = col; row >= 0; row --) {
                if (row == col) {
                    //base 对角线处全是1
                    dp[row][col] = 1;
                } else {
                    if (s.charAt(row) == s.charAt(col)) {
                        dp[row][col] = dp[row + 1][col -1] + 2;
                    } else {
                        dp[row][col] = Math.max(dp[row + 1][col], dp[row][col -1]);
                    }
                }
            }
        }
        return dp[0][s.length() -1];
    }
}
