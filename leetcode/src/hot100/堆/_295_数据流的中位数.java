package hot100.堆;

import java.util.PriorityQueue;

public class _295_数据流的中位数 {
    class MedianFinder {
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large;

        public MedianFinder() {
            // 小顶堆: 每个结点的值都小于或等于其左右孩子结点的值。
            large = new PriorityQueue<>();
            // 大顶堆: 每个结点的值都大于或等于其左右孩子结点的值。
            small = new PriorityQueue<>((a, b) -> {
                return b - a;
            });
        }

        public void addNum(int num) {
            // 每次添加元素时，如果两个堆的大小相等，就往大顶堆加，否则往小顶堆加
            // 往大顶堆加的时候，先将该元素加入小顶堆排序，然后把小顶堆的最大值放入大顶堆
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {    // 大顶堆的数量小于小顶堆了 先加小顶堆 因为先走前一个判定，所以他们的数量最多只会差1
                large.offer(num);
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            } else if (small.size() < large.size()) {
                return large.peek();
            } else {
                return (small.peek() + large.peek()) / 2.0;
            }
        }
    }
}
