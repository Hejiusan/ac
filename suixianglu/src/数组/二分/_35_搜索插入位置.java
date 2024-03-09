package 数组.二分;

/**
 * https://leetcode.cn/problems/search-insert-position/
 */
public class _35_搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int middle = (left + right) / 2;
            if (nums[middle] > target){
                // 在左边
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }else   // 找到了
                return middle;
        }
        // 找不到有三种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， 因为是右闭区间，所以 return right + 1
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
}
