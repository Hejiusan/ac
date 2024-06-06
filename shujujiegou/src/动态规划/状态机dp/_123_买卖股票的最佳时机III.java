package 动态规划.状态机dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _123_买卖股票的最佳时机III {
    /*
    一天一共就有五个状态，
    0: 没有操作 （其实我们也可以不设置这个状态）
    1: 第一次持有股票
    2: 第一次不持有股票
    3: 第二次持有股票
    4: 第二次不持有股票
    dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金。

    dp[i][0] = dp[i - 1][0];    第i天没有操作，延续第i-1天
    dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);   第i天第一次持有，可能是之前就持有，也可能是第i天才买入
    dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i]);   第i天不持有，可能是之前就卖出，也可能是第i天才卖出
    dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);   第i天第二次持有，可能是之前就第二次持有，也可能第i天才第二次买入
    dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);   第i天第二次不持有，同理
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int[][] dp = new int[len + 1][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[len - 1][4];
    }
}
