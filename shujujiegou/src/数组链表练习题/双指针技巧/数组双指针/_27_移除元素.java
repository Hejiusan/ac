package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/remove-element/
 * 也是用到快慢指针思想
 * 如果 fast 遇到值为 val 的元素，则直接跳过，否则就赋值给 slow 指针，并让 slow 前进一步。
 * <p>
 * 注意这里和有序数组去重的解法有一个细节差异，我们这里是先给 nums[slow] 赋值然后再给 slow++，
 * 这样可以保证 nums[0..slow-1] 是不包含值为 val 的元素的，最后的结果数组长度就是 slow。
 */
public class _27_移除元素 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {

                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
