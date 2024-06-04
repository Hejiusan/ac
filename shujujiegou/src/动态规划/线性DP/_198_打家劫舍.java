package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/house-robber/description/
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class _198_打家劫舍 {
    /*
    dp[i]: 表示从0~i的房屋里，能够偷窃到的最高金额
    dp[i]由 第 i 个房间偷(dp[i] = dp[i-2]+ nums[i])   或不偷 (dp[i] = dp[i-1])这两种状态得来
    所以状态转移方程为：dp[i] = Math.max(dp[i-2]+ nums[i], dp[i-1])
     */
    public int rob(int[] nums) {
        int lens = nums.length;
        int[] dp = new int[lens + 1];
        if (lens == 1){
            return nums[0];
        }
        // 初始化
        dp[0] = nums[0];    // 第一个房间是从下标0开始
        dp[1] = Math.max(nums[0], nums[1]);

        // 防止越界，i要从2开始
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+ nums[i], dp[i-1]);
        }

        return dp[lens - 1];
    }
}
