package 数据结构设计.队列和栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 *
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class _232_用栈实现队列 {
    class MyQueue {
        private Stack<Integer> s1, s2;
        public MyQueue() {
            // 初始化两个栈
            s1= new Stack<>();
            s2= new Stack<>();
        }

        /**
         * 元素入队 添加元素到队尾
         * @param x
         */
        public void push(int x) {
            s1.push(x);
        }

        /**
         * 删除队头的元素并返回
         * @return
         */
        public int pop() {
            peek(); // 先调用peek 保证s2非空
            return s2.pop();
        }

        /**
         * s1入栈，谈到s2做中转
         * @return
         */
        public int peek() {
            if (s2.isEmpty()){  // 先保证s2为空，这样把s1的弹进去就变成队列的顺序了
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
