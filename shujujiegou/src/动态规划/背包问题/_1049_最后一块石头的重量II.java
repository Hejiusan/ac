package 动态规划.背包问题;

/**
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 *
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 */
public class _1049_最后一块石头的重量II {
    // 尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
    // stones[]同时是物品的重量和价值
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum/2;     // 向下取整
        // dp[j]: 表示容量为j的背包所能容纳的最大重量
        int []dp = new int[3001];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        // dp[target]：容量为target的背包所能容纳的最大重量
        // 分成了两堆重量接近的石头，那么另一堆石头的重量为 sum-dp[target]
        // target是向下取整的 ==》 sum-dp[target] > dp[target]
        return (sum - dp[target]) - dp[target]; // 两堆重量相近的石头相减，重量最小
    }
}
