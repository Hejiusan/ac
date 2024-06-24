package hot100.普通数组;

/**
 * https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class _41_缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        /*
         对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中
         这里找的是从1开始没有出现的最小正整数
         */

        // 原地哈希
        /*
        对于每个 nums[i]，如果它在 [1, n] 范围内，并且 nums[i] 不在它正确的位置上（即 nums[nums[i] - 1] != nums[i]），
        我们就将 nums[i] 和 nums[nums[i] - 1] 交换。通过这种方式，我们可以将每个数放到它应在的位置上。
         */
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 交换 nums[i] 和 nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 查找第一个缺失的正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

}
