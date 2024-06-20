package hot100.普通数组;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 */
public class _53_最大子数组和 {
    /*
    动态规划：
    dp[i]: 以nums[i] 为结尾的「最大子数组和」为 dp[i]
    递推关系：
    和前面的一起组成更长的连续子数组 或 重新开始
    和前面一起 ==> dp[i] = dp[i-1] + nums[i]
    不和前面一起 == > dp[i] = nums[i]
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
