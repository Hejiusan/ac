package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/
 *
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class _674_最长连续递增序列 {
    /*
    dp[i]：以下标i为结尾的连续递增的子序列长度为dp[i]。
    如果 nums[i] > nums[i - 1]，那么以 i 为结尾的连续递增的子序列长度 一定等于 以i - 1为结尾的连续递增的子序列长度 + 1 。
    状态转移方程：
        dp[i] = dp[i-1] + 1

     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        // 初始化全为1，因为最少一个数也是一个长度
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])
                dp[i] = dp[i-1] + 1;
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
