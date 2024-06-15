package 动态规划.状态机dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/
 * <p>
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _188_买卖股票的最佳时机IV {
    /*
    dp[i][j] ：第i天的状态为j，所剩下的最大现金是dp[i][j]
    j为奇数持有，偶数不持有
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];
        // 初始化, 买入的时候就是花钱
        for (int j = 1; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1;i < len; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);    // 奇数考虑持有
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);    // 偶数不持有考虑卖出
            }
        }
        return dp[len - 1][2 * k];
    }
}
