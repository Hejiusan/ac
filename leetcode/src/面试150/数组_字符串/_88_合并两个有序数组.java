package 面试150.数组_字符串;

/**
 * https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
 * nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0){
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while( i >= 0){
            nums1[k--] = nums1[i--];
        }
        while( j>= 0){
            nums1[k--] = nums2[j--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        int k = 0;
        int[] res = new int[len];
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n){
            if (nums1[p1] < nums2[p2]){
                res[k++] = nums1[p1++];
            }else {
                res[k++] = nums2[p2++];
            }
        }
        while (p1 < m){
            res[k++] = nums1[p1++];
        }
        while (p2 < n){
            res[k++] = nums2[p2++];
        }
        for (int i = 0; i < len; i++) {
            nums1[i] = res[i];
        }

    }
}
