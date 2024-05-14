package 动态规划.线性DP;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/russian-doll-envelopes/description/
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 *
 * 最长递归子序列拓展到二维
 */
public class _354_俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        // 因为要求最多的个数。所以肯定需要排序
        // 先对宽度w进行升序排序，如果w相同，则按照高度h降序排序，之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
        //对宽度 w 从小到大排序，确保了 w 这个维度可以互相嵌套，所以我们只需要专注高度 h 这个维度能够互相嵌套即可。
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            return a[0] == b[0] ?
                    b[1] - a[1] : a[0] - b[0];
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public static int lengthOfLIS(int[] nums) {
        int res = 0;
        // dp[i]: 表示以第i个数结尾的最长递增子序列的长度
        int dp[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;  // 找不到前面数字小于自己的时候就为1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
