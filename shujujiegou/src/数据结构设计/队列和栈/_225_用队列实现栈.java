package 数据结构设计.队列和栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/description/
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
public class _225_用队列实现栈 {
    class MyStack {
        Queue<Integer> q1, q2;
        int top_elem = 0;   // 记录栈顶元素 也就是最后一个入队的元素
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /**
         * 入栈
         * @param x
         */
        public void push(int x) {
            q1.offer(x);
            top_elem = x;
        }

        public int pop() {
            while (q2.isEmpty()){
                if (!q1.isEmpty()){
                    int size = q1.size();
                    // 留下队尾两个元素
                    while (size > 2){
                        q2.offer(q1.poll());
                        size--;
                    }

                    if (size == 1){
                        return q1.poll();
                    }else{
                        top_elem = q1.peek();
                        // 记录新的队尾元素
                        q2.offer(q1.poll());   // 倒数第二个元素继续入队
                        return q1.poll();   // 把q1中的最后一个 也就是栈顶元素弹出
                    }

                }
            }
            return q2.poll();
        }

        public int top() {
            return top_elem;
        }

        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }
}
