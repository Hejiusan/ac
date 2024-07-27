package 第一讲;

import java.util.Stack;

public class _41_包含min函数的栈 {
    class MinStack {
        Stack<Integer> stk;
        // 用来记录栈的最小元素放在栈顶
        Stack<Integer> minstk;

        /** initialize your data structure here. */
        public MinStack() {
            stk = new Stack<>();
            minstk = new Stack<>();
        }

        public void push(int x) {
            stk.push(x);
            if (minstk.isEmpty() || minstk.peek() >= x){
                minstk.push(x);
            }
        }

        public void pop() {
            if (minstk.peek().equals(stk.peek())){
                minstk.pop();
            }
            stk.pop();
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            return minstk.peek();
        }
    }

}
