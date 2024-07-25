package hot100.贪心;

/**
 * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);   // 每次更新最大覆盖范围，能覆盖到他就肯定能跳到
            if (cover >= nums.length - 1) return true; // 说明可以覆盖到终点了
        }
        return false;
    }
}
