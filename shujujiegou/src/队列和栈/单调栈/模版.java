package 队列和栈.单调栈;

import java.util.Stack;

public class 模版 {
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            // 这里是要找下一个更大的元素 所以比他小的元素就弹出去
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的更大元素
            // 对于位置 i 的元素，其右侧第一个更大的元素是当前的栈顶元素（如果栈不为空）。
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

}
