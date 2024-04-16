package 数组链表练习题.前缀和;

import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/description/?show=1
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class _238_除自身以外数组的乘积 {


    public static int[] productExceptSelf(int[] nums) {
        ArrayList<Integer> preProduct_L = new ArrayList<>();    // 前缀积
        ArrayList<Integer> preProduct_R = new ArrayList<>();    // 后缀积

        int n = nums.length;
        int[] answer = new int[n];


        // 计算当前元素的前缀积
        preProduct_L.add(1);
        for (int i = 1; i < n; i++) {
            preProduct_L.add(preProduct_L.get(i - 1) * nums[i - 1]);
        }

        // 计算当前元素的后缀积
        // 注意这里循环反着来  但是索引得顺着来
        preProduct_R.add(1);
        for (int i = n-2; i >= 0; i--) {
            preProduct_R.add(preProduct_R.get(n - i - 2) * nums[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            answer[i] = (preProduct_L.get(i) * preProduct_R.get(n-i-1));
        }
        return answer;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,4};
        int[]res = productExceptSelf(nums);
        System.out.println(res);
    }

}
