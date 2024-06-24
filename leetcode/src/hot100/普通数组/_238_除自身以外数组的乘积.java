package hot100.普通数组;
/*
https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked

给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class _238_除自身以外数组的乘积 {
    /*
    前缀和思想，前缀积
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 初始化第一个元素的前缀积为 1
        answer[0] = 1;
        // 计算前缀积
        for (int i = 1; i < n; i++) {
            // 当前元素的前缀积等于前一个元素的前缀积乘以前一个元素的值。
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 初始化后缀积为 1
        int suffixProduct = 1;
        // 计算后缀积并更新结果
        for (int i = n - 1; i >= 0; i--) {
            // 当前元素的结果等于前缀积乘以当前的后缀积。
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}
