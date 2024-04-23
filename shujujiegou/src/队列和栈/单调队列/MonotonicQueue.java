package 队列和栈.单调队列;

import java.util.LinkedList;

class MonotonicQueue {
    // 双链表，支持头部和尾部增删元素
    // 维护其中的元素 自尾部到头部单调递增
    private LinkedList<Integer> maxq = new LinkedList<>();

    // 在尾部添加一个元素 n, 维护maxq的单调性质
    public void push(int n) {
        // 将前面小于自己的元素都删除
        while (!maxq.isEmpty() && maxq.getLast() < n) {
            maxq.pollLast();
        }
        maxq.addLast(n);
    }

    public Integer max() {
        // 队头的元素肯定是最大的
        return maxq.getFirst();
    }

    public void pop(int num) {
        if (num == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
}