package hot100.二分搜索;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，
 * 原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class _153_寻找旋转排序数组中的最小值 {
    /*
    不管旋转多少次，他一定是两部分都是有序的，找到mid和两个子数组的关系来确定搜索范围
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 这里使用left < right 意味着退出循环时 left = right
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){   // 如果中间元素大于right元素 == 》 右侧是小的那一部分
                // 最小值在右边
                left = mid + 1;
            }else {
                // 最小值在左边
                right = mid;    // 因为else包含了等于的情况  所以不要减一
            }
        }
        return nums[left];
    }
}
