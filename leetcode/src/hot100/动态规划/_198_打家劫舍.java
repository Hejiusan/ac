package hot100.动态规划;

/**
 * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class _198_打家劫舍 {
    /*
    dp[i]: 表示在前i间房屋中，能够偷窃到的最高金额
    状态转移：
    偷第i     == 》 nums[i] + dp[i-2]
    不偷第i    ==>  dp[i-1]
    dp[i] = max(dp[i-1], nums[i] + dp[i-2])

     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)   return nums[0];
        int[] dp = new int[len];
        // 初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[len - 1];

    }
}
