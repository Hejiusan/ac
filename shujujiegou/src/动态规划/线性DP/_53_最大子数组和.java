package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class _53_最大子数组和 {
    /*
    dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。
    递推公式：两个来源
        dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
        nums[i]，即：重新开始计算当前连续子序列和
        ==> dp[i] = max(dp[i - 1] + nums[i], nums[i]);
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int res = dp[0];    // 不能初始化为0 否则nums的长度为1 时，直接就return res = 0了
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;

    }
}
