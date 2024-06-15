package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/house-robber-ii/description/
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class _213_打家劫舍II {
    /*
    dp[i]: 表示从0~i的房屋里，能够偷窃到的最高金额
    这里有三种情况，第一间和最后一间都不偷，偷第一间不偷最后那件   或者偷最后一间不偷第一间
    但是其实第一种情况已经被包括在二三里了

     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int result1 = robRange(nums, 0, nums.length - 2); // 情况二, 不偷最后那件
        int result2 = robRange(nums, 1, nums.length - 1); // 情况三，不偷第一件
        return Math.max(result1, result2);
    }

    private int robRange(int[] nums, int left, int right) {
        int[] dp = new int[right + 1];
        if (left == right){
            return nums[left];
        }
        // 初始化
        dp[left] = nums[left];    // 第一个房间是从下标0开始
        dp[left + 1] = Math.max(nums[left], nums[left+1]);

        // 防止越界，i要从2开始
        // 注意边界，已经是取得到的值
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i-2]+ nums[i], dp[i-1]);
        }

        return dp[right];
    }
}
