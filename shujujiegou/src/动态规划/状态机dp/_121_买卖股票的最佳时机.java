package 动态规划.状态机dp;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class _121_买卖股票的最佳时机 {
    /*
    dp[i][0] 表示第i天持有股票所得最多现金
    dp[i][1] 表示第i天不持有股票所得最多现金
    如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
        第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
        第i天买入股票，所得现金就是买入今天的股票后所得现金即：-prices[i]
        所以状态转移方程：dp[i][0] = max(dp[i - 1][0], -prices[i]);
    同理：
        第i-1天就已经卖了  和  第i天才卖
        dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        // 肯定是卖出去才能获得最大收益
        return dp[prices.length - 1][1];
    }
}
