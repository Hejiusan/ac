package 动态规划.状态机dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * <p>
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _309_买卖股票的最佳时机含冷冻期 {
    /*
    dp[i][j]，第i天状态为j，所剩的最多现金为dp[i][j]。
    状态一：持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
        第i天买入可以细分为两种状态
            前一天是冷冻期（状态四），dp[i - 1][3] - prices[i]
            前一天是保持卖出股票的状态（状态二），dp[i - 1][1] - prices[i]
        dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i], dp[i - 1][3] - prices[i])
    不持有股票状态，这里就有两种卖出股票状态
        状态二：保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。dp[i-1][1]  或者是前一天就是卖出股票状态，一直没操作  dp[i-1][3])）
        dp = max(dp[i-1][1], dp[i-1][3])

        状态三：今天卖出股票  dp[i-1][0] + prices[i]

    状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
        前一天卖出去进入冷冻期 dp[i-1][2]
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len + 1][4];
        dp[0][0] = -prices[0];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        // 卖掉才能获得最大利润, 可以是卖了，也可以是刚卖完的冷静期
        return Math.max(dp[len - 1][3], Math.max(dp[len - 1][1], dp[len - 1][2]));

    }
}
