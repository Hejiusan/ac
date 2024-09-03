package 面试150.动态规划;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class _122_买卖股票的最佳时机II {
    /*
    可以多次买入
    dp[i][0]：表示在第i天持有
        可以是第i天买入    dp[i][0] - prices[i]
        也可以之前就买入    dp[i-1][0]
    dp[i][1]：表示在第i天不持有
        第i天卖出       dp[i][1] + prices[i]
        之前就卖了       dp[i-1][1]
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
    }
}
