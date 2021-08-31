package com.zh.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 *
 * 354. 俄罗斯套娃信封问题
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 * 示例 1：
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class MaxEnvelopes {
    /**
     * 套娃关系定义了一种对信封的偏序关系，等价于在按照宽度/长度排序后的序列中找LIS
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparing(e -> e[0])); //这里按照宽度和长度排序都可以
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < envelopes.length; i ++) {
            dp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (greater(envelopes[i], envelopes[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return  max;
    }

    private boolean greater(int[] left, int[] right) {
        return left[0] > right[0] && left[1] > right[1];
    }
}
