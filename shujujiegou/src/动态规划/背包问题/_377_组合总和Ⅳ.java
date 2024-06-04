package 动态规划.背包问题;

/**
 * https://leetcode.cn/problems/combination-sum-iv/
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 */
public class _377_组合总和Ⅳ {
    /*
    dp[i]: 凑成目标正整数为i的排列个数为dp[i]
    dp[i]（考虑nums[j]）可以由 dp[i - nums[j]]（不考虑nums[j]） 推导出来。
    因为只要得到nums[j]，排列个数dp[i - nums[j]]，就是dp[i]的一部分。
    状态转移方程：
    dp[i] += dp[i - nums[j]]
     */

    public int combinationSum4(int[] nums, int target) {
        // 定义dp数组，长度为target + 1
        int[] dp = new int[target + 1];
        dp[0] = 1; // 凑成总和0的方法只有一种，不使用任何元素

        // 题目是组合，但本质是求排列问题 意味着  1 1 2 和2 1 1 是不同的
        // 所以要先遍历背包 在遍历物品
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }


        return dp[target]; // 返回凑成目标总和target的组合数
    }
}
