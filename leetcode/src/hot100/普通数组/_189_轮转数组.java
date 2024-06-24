package hot100.普通数组;

/**
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 对数组进行三次特定的反转操作可以达到将数组右移  k  个位置的效果
 *
 *  1.	反转整个数组：
 * 	•	如果我们反转整个数组，那么数组会变成 [an, an-1, ..., a1]。
 * 	•	例子：对于数组 [1, 2, 3, 4, 5, 6, 7]，反转后得到 [7, 6, 5, 4, 3, 2, 1]。
 * 	2.	反转前  k  个元素：
 * 	•	接着反转前  k  个元素，目标是将这些元素放到最终位置上。
 * 	•	例子：反转前 3 个元素 [7, 6, 5] 得到 [5, 6, 7]，整个数组变为 [5, 6, 7, 4, 3, 2, 1]。
 * 	3.	反转剩余的元素：
 * 	•	最后反转剩余的元素，将它们恢复到正确的顺序。
 * 	•	例子：反转剩余的元素 [4, 3, 2, 1] 得到 [1, 2, 3, 4]，最终数组变为 [5, 6, 7, 1, 2, 3, 4]。
 */
public class _189_轮转数组 {
    public void rotate(int[] nums, int k) {
        // 确保 k 在数组长度范围内
        k = k % nums.length;
        // 反转整个数组
        reverse(nums, 0, nums.length - 1);
        // 反转前 k 个元素
        reverse(nums, 0, k - 1);
        // 反转剩余的元素
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 翻转数组
     * @param nums
     * @param left
     * @param right
     */
    private void reverse(int[] nums, int left, int right) {
        while (left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }


}
