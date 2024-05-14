package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 * 。
 */
public class _300_最长递增子序列 {
    public static int lengthOfLIS(int[] nums) {
        int res = 0;
        // dp[i]: 表示以第i个数结尾的最长递增子序列的长度
        int dp[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;  // 找不到前面数字小于自己的时候就为1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,2,3};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
