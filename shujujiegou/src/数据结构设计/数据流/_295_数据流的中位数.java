package 数据结构设计.数据流;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/find-median-from-data-stream/description/
 *
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 *
 * 使用两个优先队列
 */
public class _295_数据流的中位数 {
    class MedianFinder {
        private final PriorityQueue<Integer> large;
        private final PriorityQueue<Integer> small;

        public MedianFinder() {
            //大顶堆：每个结点的值都大于或等于其左右孩子结点的值。
            //小顶堆：每个结点的值都小于或等于其左右孩子结点的值。
            // 小顶堆
            large = new PriorityQueue<>();
            // 大顶堆
            small = new PriorityQueue<>((a, b) -> {
                return b - a;
            });
        }

        public double findMedian() {

            // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
            if (large.size() < small.size()) {
                return small.peek();
            } else if (large.size() > small.size()) {
                return large.peek();
            }
            // 如果元素一样多，两个堆堆顶元素的平均数是中位数
            return (large.peek() + small.peek()) / 2.0;

        }

        public void addNum(int num) {
            // 每次添加元素时，如果两个堆的大小相等，就往大顶堆加，否则往小顶堆加
            // 往大顶堆加的时候，先将该元素加入小顶堆排序，然后把小顶堆的最大值放入大顶堆
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        }
    }

}
