package 第六讲;

import java.util.Scanner;

public class _1057_股票买卖IV {
    /*
    dp[i][j] ：第i天的状态为j，所剩下的最大现金是dp[i][j]
    j为奇数持有，偶数不持有
    奇数持有，可能是第i天买的，也可能在前一天就买了
        第i天买入: 由第i-1天的未持有状态转换而来  dp[i][j+1] = dp[i-1][j] - price[i]
        之前就持有了，由第i-1天的持有转换而来     dp[i][j+1] = dp[i-1][j+1]    j+1是为了确保为奇数
    同理，偶数不持有 卖出
        dp[i][j+2] = max(dp[i-1][j+2],    dp[i-1][j+1] + price[i])
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] prices = new int[n];
        s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(s[i]);
        }
        int res = maxProfit(k, prices);
        System.out.println(res);

    }

    private static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];
        // 初始化，买入的时候就是花钱  j为奇数
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
