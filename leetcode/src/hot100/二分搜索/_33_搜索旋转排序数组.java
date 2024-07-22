package hot100.二分搜索;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class _33_搜索旋转排序数组 {
    /*
    在未知的位置旋转，至少保证了有一半的区间内的数据是有序的，先找到有序的那一半
     */
    public int search(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;
       while (left <= right){
           int mid = left + (right - left) / 2;
           if (nums[mid] == target){
               return mid;
           }
           /*
           nums = [4,5,6,7,0,1,2]   // left <= mid ==> 左半部分有序
           nums = [5,6,7,1,2,3,4]   // left > mid ==> 右半部分有序
            */
           // while循环使用小于等于一般是结果会在循环内部解决
           if (nums[left] <= nums[mid]){    // 左半部分是有序
               // 判断 target是否在左半边  升序
               if (target >= nums[left] && target <= nums[mid]){
                   // 在左半边 收缩right
                   right = mid;
               }else {
                   left = mid + 1;
               }

           }else {  // 右半部分有序
               // target是否在右半边
               if (target <= nums[right] && target >= nums[mid]){
                   left = mid;
               }else {
                   right = mid - 1;
               }
           }
       }
       // 最后也没能找到
       return -1;
    }
}
