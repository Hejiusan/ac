package 队列和栈.单调栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/description/
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class _739_每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 单调栈模版
        for (int i = n - 1; i >= 0; i--) {
            // 这里用whilie是因为要找到第一个更大的元素
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {    // 注意s存的是索引
                s.pop();
            }
            // 得到索引间距
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            // 索引入栈
            s.push(i);
        }
        return res;
    }
}
