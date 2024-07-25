package hot100.栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class _155_最小栈 {
    class MinStack {
        // 记录栈中的所有元素
        Stack<Integer> stk;
        // 新开一个栈来存栈中的最小元素，永远只存比栈顶元素小的值，使得栈顶元素就是栈中的最小值
        Stack<Integer> minStk;

        public MinStack() {
            stk = new Stack<>();
            minStk = new Stack<>();
        }

        public void push(int val) {
            stk.push(val);
            // 维护 minStk 栈顶为全栈最小元素
            if (minStk.isEmpty() || val <= minStk.peek()) {
                // 新插入的这个元素就是全栈最小的
                minStk.push(val);
            }
        }

        public void pop() {
            // 看pop出去的是不是栈的最小元素
            if (stk.peek().equals(minStk.peek())){
                minStk.pop();
            }
            stk.pop();

        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            // minStk 栈顶为全栈最小元素
            return minStk.peek();
        }
    }
}
