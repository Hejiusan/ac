package hot100.贪心;

/**
 * https://leetcode.cn/problems/jump-game-ii/description/
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class _45_跳跃游戏II {
    /*
    计算当前这一步的最大覆盖和下一步最大覆盖。当你在当前这步的最远覆盖距离无法跳时，
    不用管他怎么跳，反正两个区域最多两步一定能覆盖到
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curDistance = 0;    // 当前覆盖最远距离下标
        int ans = 0;            // 记录走的最大步数
        int nextDistance = 0;   // 下一步覆盖最远距离下标
        for (int i = 0; i < nums.length; i++) {
            // 更新下一步覆盖最远距离下标
            nextDistance = Math.max(i + nums[i], nextDistance);
            if (i == curDistance) {  // 如果移动到了当前覆盖最远距离下标
                // 需要走一步移动到下一个覆盖范围内
                ans++;
                curDistance = nextDistance;
                if (nextDistance >= nums.length - 1) break;  // 当前覆盖最远距到达集合终点，不用做ans++操作了，直接结束
            }
        }
        return ans;
    }
}
