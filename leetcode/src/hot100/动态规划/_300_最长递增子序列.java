package hot100.动态规划;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
 */
public class _300_最长递增子序列 {
    /*
     dp[i]: 表示以第i个数结尾的最长递增子序列的长度. 事实上 这样就是nums[i]已经被选取了，只是说可能不满足递增
     状态转移：
        在计算dp[i] 之前，我们已经计算了 dp[0~i-1]的值
        所以可以遍历j，存在 j < i 且 nums[j] < nums[i]
        dp[i]=max(dp[i], dp[j] + 1)

     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;  // 最少也有一个数，长度至少为1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
