package 队列和栈.单调栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/next-greater-element-ii/description/
 * <p>
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * 简便套路：环形数组，意味着最后的那个元素可能可以找到一个前面比他大的数；把数组扩大两倍，在应用之前的模版就可以找到啦
 * <p>
 * 环形数组，一般是通过 % 取模运算，来模拟环形特效
 * int[] arr = {1,2,3,4,5};
 * int n = arr.length, index = 0;
 * while (true) {
 * // 在环形数组中转圈
 * print(arr[index % n]);
 * index++; }
 */
public class _503_下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {  // 数组扩大两倍模拟环形数组
            // 索引 i要取模，其他就是套魔板
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }
}
