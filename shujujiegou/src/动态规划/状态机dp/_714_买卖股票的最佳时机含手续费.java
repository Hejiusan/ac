package 动态规划.状态机dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费
 */
public class _714_买卖股票的最佳时机含手续费 {
    /*
    只能持有一只股票，和_122_买卖股票的最佳时机II一样，只是卖出的时候多支付一笔手续费
    dp[i][0]: 表示第i天持有股票所得现金。
        可以是第i-1天买了股票，然后没卖 dp[i-1][0]
        也可以是第i天买入       dp[i-1][1] - prices[i]

    dp[i][1]: 第i天不持有股票所得现金。
        可以是早就卖了 dp[i-1][1]
        也可以是第i天才卖   dp[i-1][0] + prices[i] - fee
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int[][] dp = new int[len + 1][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }
        return dp[len - 1][1];
    }
}
