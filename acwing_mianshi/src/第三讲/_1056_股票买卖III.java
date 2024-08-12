package 第三讲;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1058/
 *
 * 给定一个长度为 N的数组，数组中的第 i 个数字表示一个给定股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _1056_股票买卖III {
    /*
     一天一共就有五个状态，
    0: 没有操作 （其实我们也可以不设置这个状态）
    1: 第一次持有股票
    2: 第一次不持有股票
    3: 第二次持有股票
    4: 第二次不持有股票
    dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金。
    状态转移：第i天的五种状态
    0：没有操作 dp[i][0] = dp[i-1][0]    延续上一天
    1: 在第i天是第一次交易里的持有，可能是第一次买入也可能是之前就买了 dp[i][1] = max(dp[i-1][0] - price[i], dp[i-1][1]);
    2: 第i天第一次没有持有，可能之前就卖了，也可能第i天卖了          dp[i][2] = max(dp[i-1][2], dp[i-1][1] + price[i]);
    3: 第i天第二次持有：可能是第i天买的，也可能之前就买入了          dp[i][3] = max(dp[i-1][2] - price[i], dp[i-1][3]);
    4: 第i天第二次不持有，可能是之前卖的，也可能是第i天卖的          dp[i][4] = max(dp[i-1][3] + price[i], dp[i-1][4]);

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        int[][] dp = new int[n][5];
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            price[i] = Integer.parseInt(s[i]);
        }
        // 买入就得扣钱
        dp[0][1] = -price[0];
        dp[0][3] = -price[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i-1][0] - price[i], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + price[i]);
            dp[i][3] = Math.max(dp[i-1][2] - price[i], dp[i-1][3]);
            dp[i][4] = Math.max(dp[i-1][3] + price[i], dp[i-1][4]);
        }
        System.out.println(dp[n-1][4]);
    }
}
