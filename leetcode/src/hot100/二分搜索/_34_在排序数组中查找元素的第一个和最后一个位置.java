package hot100.二分搜索;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    int[] res;

    public int[] searchRange(int[] nums, int target) {
        // 先找左端点(最大的最小值点)
        int left = 0;
        int right = nums.length - 1;
        int mid;
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        while (left < right) {
            // 找左端点 mid 不用+1 判断时先更新left
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            // 要查找的值不在数组中，直接返回
            res = new int[]{-1, -1};
        } else {
            // 已经找到左端点了，就继续二分找右端点（最小的最大值点）
            res = new int[2];
            res[0] = left;
            left = 0;
            right = nums.length - 1;
            // 找右端点 mid +1 判断时先更新right
            while (left < right) {
                mid = (left + right + 1) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }

            }
            res[1] = left;

        }
        return res;

    }
}
