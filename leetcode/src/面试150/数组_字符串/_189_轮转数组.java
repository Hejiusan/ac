package 面试150.数组_字符串;

/**
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
        1、翻转整个数组 7 6 5 4 3 2 1
        2、翻转前k个   5 6 7 4 3 2 1
        3、翻转后面的  5 6 7 1 2 3 4
 */
public class _189_轮转数组 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;    // 确保k在长度范围内
        // 反转整个数组
        reverse(nums, 0, nums.length - 1);
        // 反转前 k 个元素
        reverse(nums, 0, k-1);
        // 反转剩下的元素
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
