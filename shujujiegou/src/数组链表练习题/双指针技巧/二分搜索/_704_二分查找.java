package 数组链表练习题.双指针技巧.二分搜索;

/**
 * https://leetcode.cn/problems/binary-search/description/
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class _704_二分查找 {
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l<=r){   // 这里是[l,r]皆为闭区间，因为区间可能只有一个值
            int mid = (l+r)/2;
            if (target == nums[mid]){
                return mid;
            } else if (target > nums[mid]) {    //target在[mid+1, r]
                l = mid + 1;
            } else if (target < nums[mid]) {    //target在[l, mid-1]
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int res = search(nums, 2);
        System.out.println(res);
    }
}
