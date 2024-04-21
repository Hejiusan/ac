package 数组链表练习题.双指针技巧.二分搜索;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int middle;
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        while (left < right){
            middle = (left + right) / 2;
            if (nums[middle] >= target){
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        if (nums[left] != target){
            // 要查找的值不在数组中，直接返回
            result = new int[]{-1, -1};
        }
        else {  //找到左端点了，再次二分找右端点
            result = new int[2];
            result[0] = left;
            left = 0;
            right = nums.length - 1;
            while (left < right){
                middle = (left + right + 1) / 2;
                if (nums[middle] <= target){
                    left = middle;
                } else {
                    right = middle - 1;
                }
            }
            result[1] = left;
        }
        return result;
    }
}
