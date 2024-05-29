package 动态规划.背包问题;

/**
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 */
public class _474_一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]: 最多有i个0，j个1情况下，可以形成的最大子集的数量。
        // 当没有任何字符串时，dp[0][0] = 0，表示在没有 0 和 1 的限制下，子集大小为 0。

        /*
        dp[i][j] 可以由前一个str里的字符串推导出来，str里的字符串有zeroNum个0，oneNum个1。
        我们把这个str加入子集，那么就是dp[i - zeroNum][j - oneNum] + 1
        如果不把这个str加入子集，那么就还是dp[i][j]
        所以状态转移方程为：dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
         */
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            // 统计0和1的数量
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            // 从后向前遍历，防止重复计算
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
