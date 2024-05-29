package 动态规划.背包问题;

/**
 * https://leetcode.cn/problems/target-sum/description/
 *
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class _494_目标和 {
    /*
    所有的数字的总和为 sum，假设加法的总和为x，那么减法的总和为 sum-x
    也就是要求得 x - (sum - x) = target ==> x = (target + sum) / 2
    此时问题就转化为，装满容量为x的背包，有几种方法。
    这里的x，就是bagSize，也就是我们后面要求的背包容量。
    大家看到(target + sum) / 2 应该担心计算的过程中向下取整有没有影响。


    dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
    dp[j] += dp[j - num]
    对于数组中的每个数 num，我们可以选择将其加入当前子集或不加入当前子集。
	如果选择加入 num，那么我们需要 dp[j - num] 之前的状态，因为 dp[j] 可以由 dp[j - num] 转移而来。每个num加入进行累加
    */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        //  x = (target + sum) / 2
        //  如果 sum+target不是偶数，那么x就不是一个整数了
        // 如果 target 的绝对值超过 sum，那么无论如何分配正负号，和都不可能达到 target。
        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) {
            return 0;
        }

        int x = (sum + target) / 2;
        return countSubsets(nums, x);
    }

    private int countSubsets(int[] nums, int x) {
        // 装满 dp[x]的最大容量
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = x; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[x];
    }
}
