package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 *  给定的数组已经有序，
 *  我们让慢指针 slow 走在后面，快指针 fast 走在前面探路，
 *  找到一个不重复的元素就告诉 slow 并让 slow 前进一步。这样当 fast 指针遍历完整个数组 nums 后，**nums[0..slow] 就是不重复元素**。
 */
public class _26_删除有序数组中的重复项 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int fast = 0, slow = 0;
            while (fast <nums.length){
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
