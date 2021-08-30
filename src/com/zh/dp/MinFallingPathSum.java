package com.zh.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 *
 * 输入：matrix = [[2,1,3],
 *                [6,5,4],
 *                [7,8,9]]
 * 输出：13
 * 解释：下面是两条和最小的下降路径, 1 -> 5 -> 7,  1 -> 4 -> 8
 *
 */
public class MinFallingPathSum {

    /**
     * 定义问题：
     * 尝试1： dp[i][j]: 以(i,j)为最后一个元素的矩阵的minFallingPathSum， 很难写出递推式
     * 尝试2： dp[i][j]: 以(i,j)为从0行下落至i行，并且下落点是(i,j)的fallingPathSum，原问题则是Min {dp[m][j], 0 < j < n};
     *         dp[i][j] = Min {dp[i - 1][j], dp[i- 1][j-1], dp[i-1][j+1]} + matrix[i][j]
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j ++) {
                if (i == 0) {
                    //base
                    dp[0][j] = matrix[0][j];
                } else {
                    int min = j == 0 ? dp[i-1][0] : Math.min(dp[i-1][j-1], dp[i-1][j]);
                    min = j == (col -1) ? min : Math.min(min, dp[i-1][j+1]);
                    dp[i][j] = min + matrix[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            if (dp[row -1][j] < min) {
                min = dp[row - 1][j];
            }
        }
        return min;
    }
}
