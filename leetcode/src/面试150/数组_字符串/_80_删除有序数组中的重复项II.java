package 面试150.数组_字符串;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class _80_删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int count = 0;
        while (fast < nums.length){
            // 不同元素，肯定可以加进来
            if (nums[slow] != nums[fast]){
                // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                slow++;
                nums[slow] = nums[fast];
            }else if (slow < fast && count < 2) {
                // 重复次数不超过2 也加进来
                // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                slow++;
                nums[slow] = nums[fast];
            }
            // fast走一步 就记录他的count
            fast++;
            count++;
            // 重置count
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                // fast 遇到新的不同的元素时，重置 count
                count = 0;
            }

        }
        // 数组长度为索引+1
        return slow + 1;
    }
}
