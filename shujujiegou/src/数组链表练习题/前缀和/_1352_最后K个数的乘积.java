package 数组链表练习题.前缀和;

import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/product-of-the-last-k-numbers/description/?show=1
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 *
 * 1. add(int num)
 *
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 *
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 */
public class _1352_最后K个数的乘积 {
    class ProductOfNumbers {

        // 前缀积数组 preProduct[i] 存的是从0...到i的乘积
        // preProduct[i] / preProduct[j] 就是 [i, j] 之间的元素积
        ArrayList<Integer> preProduct = new ArrayList<>();

        public ProductOfNumbers() {
            // 初始化放一个 1，便于计算后续添加元素的乘积
            preProduct.add(1);
        }

        public void add(int num) {
            // 考虑乘0的情况，直接清空
            if (num == 0) {
                // 如果新添加的元素是 0，则[i,j]的乘积都会为0
                preProduct.clear();
                preProduct.add(1);
                return;
            }

            int n = preProduct.size();
            // add加一个数进去，前缀🐔数组 就要在前一位基础上再乘新加的数
            preProduct.add(preProduct.get(n - 1) * num);
        }

        public int getProduct(int k) {
            // 返回最后k个数的乘积 也就是preProduct.size()-k开始
            int n = preProduct.size();

            if (k>n-1){
                // 不足k个元素
                return 0;
            }

            // 计算最后 k 个元素积
            return preProduct.get(n - 1) / preProduct.get(n - 1 - k);
        }
    }
}
