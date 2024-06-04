package 动态规划.背包问题;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/perfect-squares/description/
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class _279_完全平方数 {
    /*
    转化
    给你一个目标金额 n，和一个若干硬币的面额 coins = 1,4,9,16...，问你最少需要几枚硬币凑出这个金额（因为包含面值为 1 的硬币，所以不存在凑不出来的情况）。
    dp[i]:  定义：和为 i 的平方数的最小数量是 dp[i]
    状态转移：
    和为 n 可以由 n- 1x1, n- 2x2, n- 3x3...n-j*j 的平方数的最小数量推导出来。
     i - j * j 只要再加一个平方数 j * j 即可凑出 i ==>   dp[i] = dp[i-j*j] + 1
     */
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);  //初始化为极大值
        // base case
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
