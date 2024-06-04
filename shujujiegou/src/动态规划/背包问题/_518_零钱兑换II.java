package 动态规划.背包问题;

/**
 * https://leetcode.cn/problems/coin-change-ii/description/
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class _518_零钱兑换II {
    public int change(int amount, int[] coins) {
        // dp[j]: 凑成总金额j的货币组合数为dp[j]
        // dp[j] 就是所有的dp[j - coins[i]]（考虑coins[i]的情况）相加
        // 如果我们要凑成金额 j，我们可以将当前硬币 coin 加入到凑成金额 j - coin 的组合中。
        // 转移方程：dp[j] += dp[j - coins[i]];
        int[] dp = new int[amount+1];
        dp[0] = 1;
        // 这里本质是求组合问题，所以先遍历物品 在遍历背包
        for (int i = 0; i < coins.length; i++) { // 遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount]; // 返回凑成金额 amount 的组合数
    }
}
