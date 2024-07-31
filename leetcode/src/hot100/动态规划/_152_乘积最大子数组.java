package hot100.动态规划;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组(该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 */
public class _152_乘积最大子数组 {
    /*
    	1.	初始化：
        •	使用两个变量 maxProduct 和 minProduct 分别记录到当前位置为止的最大乘积和最小乘积。(因为有负负得正的情况)
        •	使用一个变量 result 来记录全局的最大乘积。
        2.	遍历数组：
            对于每个元素，当遇到负数时，原本的最大乘积变成了小的，而小的会变成大的那个，需要进行交换
        •	计算当前元素乘以之前的最大乘积、当前元素乘以之前的最小乘积。
        •	更新 maxProduct 为这两个值中的最大值。
        •	更新 minProduct 为这两个值中的最小值。
        •	更新 result 为全局的最大值。
        3.	返回结果：
        •	最后返回 result 即可。
     */
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // 如果当前值是负数，交换maxProduct和minProduct
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(current, current * maxProduct);
            minProduct = Math.min(current, current * minProduct);

            result = Math.max(result, maxProduct);
        }

        return result;

    }
}
