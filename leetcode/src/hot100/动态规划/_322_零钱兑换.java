package hot100.动态规划;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class _322_零钱兑换 {
    /*
    dp[i]: 凑够金额i所需的最少硬币个数
    状态转移：选择一枚硬币。数量+1，所需金额为 i-coin  ==》 dp[i] = min(dp[i], dp[i-coin] + 1)
        dp[i] = dp[i-coin] + 1
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // 因为要求最小值，dp数组初始化为一个大值，当凑不出满足条件的amount时  dp[amount] 就等于初始化的值
        Arrays.fill(dp, amount + 1);
        //初始化
        dp[0] = 0;
        // 不同面额的硬币可以选
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        // 有可能凑不出amount 此时dp[i] 就等于初始化的值
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
