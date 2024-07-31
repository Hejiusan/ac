package 动态规划.背包问题;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 01背包的思想
 * 1、背包的体积为 sum/2
 * 2、背包要放入的商品（集合里的元素）：重量为元素的数值，价值也为元素的数值
 * 3、背包如果正好装满，表示找到了总和为 sum/2 的子集
 * 4、背包中每一个元素不可以重复放入
 */
public class _416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum % 2 == 1) return false;
        // dp[j]: 表示容量为j的背包，所能容纳的最大价值为 dp[j]
        int []dp = new int[10001];
        for (int i = 0; i < n; i++) {
            for (int j = sum/2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        if (dp[sum/2] == sum/2)
            return true;
        return false;
    }
}
