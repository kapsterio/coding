package com.zh.dp;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
public class LCS {
    /**
     * 定义dp[i][j]为 s1[0...i-1] 和s2[0..j-1]的LCS,
     * dp[i][j] = dp[i-1][j-1] + 1  if s1[i-1] == s2[j-1]
     * dp[i][j] = Max {dp[i-1][j], dp[i][j-1]} if s1[i] != s2[j]
     *
     * 原问题：dp[m][n]
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i ++) {
            for (int j = 0; j <= text2.length(); j ++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (i == 0) ? j : i;
                } else {
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
