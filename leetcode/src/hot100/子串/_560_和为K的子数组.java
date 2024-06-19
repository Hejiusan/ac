package hot100.子串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 * 连续 ==》 前缀和的思想
 */
public class _560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        // 使用哈希表来存储前缀和及其出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 初始化前缀和为0的出现次数为1（即前缀和为0时，有一种情况就是不选择任何元素）
        prefixSumCount.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        // 遍历数组
        for (int num : nums) {
            // 更新当前的前缀和
            prefixSum += num;

            // 如果在哈希表中存在前缀和为 prefixSum - k，则找到一个子数组 i..j的和，其和为 k
            // prefixSum[j] - prefixSum[i] = k == >  prefixSum[i] = prefixSum[j] - k
            // 因为前缀和只会越来越大，所以不用担心后面还会出现重复的值
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            // 更新哈希表中当前前缀和的出现次数
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
