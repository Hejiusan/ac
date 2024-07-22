package hot100.二分搜索;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class _4_寻找两个正序数组的中位数 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = 0, left1 = 0, left2 = 0;
        int[] res = new int[nums1.length + nums2.length];
        while (left1 < nums1.length && left2 < nums2.length){
            if (nums1[left1] <= nums2[left2]){
                res[k++] = nums1[left1++];
            }else {
                res[k++] = nums2[left2++];
            }
        }
        // 已经有一个走到头了，剩下的那个直接往后补
        while (left1 < nums1.length)   res[k++] = nums1[left1++];
        while (left2 < nums2.length)   res[k++] = nums2[left2++];
        int mid = (res.length - 1) / 2;
        if (res.length % 2 == 0){
            return (double) (res[mid + 1] + res[mid]) / 2;
        }

        return res[mid];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
