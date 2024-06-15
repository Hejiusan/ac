package 动态规划.状态机dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润
 */
public class _122_买卖股票的最佳时机II {
    /*
    dp[i][0] 表示第i天持有股票所得现金。
    dp[i][1] 表示第i天不持有股票所得最多现金
    这里是可以多次买入和出售的
    状态转移：
    dp[i][0] 可以由两个状态得来
        第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
        第i天买入股票，所得现金就是昨天不持有股票的所得现金减去 今天的股票价格 即：dp[i - 1][1] - prices[i]
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i])
    dp[i][1]
        第i-1天就已经卖了 即dp[i-1][1]
        第i天卖也就是第 i-1天持有在加上第i天卖的  即 dp[i-1][0] + price[i]
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i])

     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];

    }
}
