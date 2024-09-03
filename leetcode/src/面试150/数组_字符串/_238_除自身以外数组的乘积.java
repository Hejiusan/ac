package 面试150.数组_字符串;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class _238_除自身以外数组的乘积 {
    /*
    前缀积 * 后缀积
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];


        // 前缀积
        int[] prefix = new int[n];
        prefix[0] = 1;  // 第1个元素的前缀积为1 他前面没有值
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];    // 第i个数的前缀积
        }

        // 后缀积
        int[] suffix = new int[n];
        suffix[n-1] = 1;    // 最后那个元素的后缀积为1
        for (int i = n-2; i >= 0 ; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }
}