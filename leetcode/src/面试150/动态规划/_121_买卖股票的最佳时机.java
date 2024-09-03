package 面试150.动态规划;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class _121_买卖股票的最佳时机 {
    /*
    dp[i][0]：表示在第i天持有
        可以是第i天买入    dp[i-1][1] - prices[i]  前一天还没有持有
        也可以之前就买入    dp[i-1][0]
    dp[i][1]：表示在第i天不持有
        第i天卖出       dp[i-1][0] + prices[i]
        之前就卖了       dp[i-1][1]
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[n-1][1];
    }
}
