package 数组.二分;

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
                middle = (left + right + 1) / 2; // +1
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

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ints = searchRange(nums, target);
        System.out.println(ints);
    }
}
