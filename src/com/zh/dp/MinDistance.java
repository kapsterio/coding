package com.zh.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class MinDistance {
    /**
     * 问题定义
     * dp[i][j]: w1[0...i-1] 和 w2[0..j-1] 的编辑距离
     * dp[i][j] = dp[i-1][j-1] if w1[i-1] == w2[j-1]
     * dp[i][j] = Min {dp[i-1][j-1] + 1 (替换), dp[i-1][j] + 1 （删除w1或插入w2）, dp[i][j-1] +1 (插入w1或者删除w2)
     *
     * 原问题： dp[m][n]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i ++) {
            for (int j = 0; j <= word2.length(); j ++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        int min = Math.min(dp[i-1][j-1], dp[i-1][j]);
                        dp[i][j] = Math.min(min, dp[i][j-1]) + 1;
                    }
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
