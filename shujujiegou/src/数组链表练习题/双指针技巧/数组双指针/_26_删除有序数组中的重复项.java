package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 * 非严格递增排列 表示递增但不是单调递增 数组已经有序了
 *
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 *  给定的数组已经有序，
 *  我们让慢指针 slow 走在后面，快指针 fast 走在前面探路，
 *  找到一个不重复的元素就告诉 slow 并让 slow 前进一步。
 *  这样当 fast 指针遍历完整个数组 nums 后，
 *  **nums[0..slow] 就是不重复元素**。
 */
public class _26_删除有序数组中的重复项 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int fast = 0, slow = 0;
            while (fast < nums.length){
                if (nums[fast] != nums[slow]){
                    slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow+1;  //索引从0开始
        }
    }
}
