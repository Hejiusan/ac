package hot100.栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class _739_每日温度 {
    // 存的是下一个更大温度的索引
    Stack<Integer> stk = new Stack<>();
    int[] res;

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        res = new int[n];
        // 找下一个更大的温度，从后往前遍历
        for (int i = n - 1; i >= 0; i--) {
            // 比当前温度小的就可以直接丢了
            while (!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i]) {
                stk.pop();
            }
            // stk.peek() - i 表示的是索引差 也就是几天后
            res[i] = stk.isEmpty() ? 0 : (stk.peek() - i);
            stk.push(i);
        }
        return res;

    }
}
