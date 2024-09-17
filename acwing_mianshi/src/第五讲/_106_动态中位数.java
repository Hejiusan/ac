package 第五讲;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/108/
 *
 * 依次读入一个整数序列，每当已经读入的整数个数为奇数时，输出已读入的整数构成的序列的中位数。
 */
public class _106_动态中位数 {
    /*
    对顶堆：左边维护一个大根堆（堆顶是最大值），右边维护一个小根堆（堆顶是最小值）
    每次插入一个新的 x，维护堆
     */
    static PriorityQueue<Integer> large;
    static PriorityQueue<Integer> small;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int id = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(id + " " + (m + 1) / 2);
            large = new PriorityQueue<>();   // 优先队列默认是大根堆
            small = new PriorityQueue<>((a, b) -> {
                return b - a;
            });
            int cnt = 0;    // 记录输出一行的数字是否到了10个，10个就要换行
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                // 每次添加元素时，如果两个堆的大小相等，就往大顶堆加，否则往小顶堆加
                // 往大顶堆加的时候，先将该元素加入小顶堆排序，然后把小顶堆的最大值放入大顶堆
                if (small.size() >= large.size()) {
                    small.offer(x);
                    large.offer(small.poll());
                } else {
                    large.offer(x);
                    small.offer(large.poll());
                }
                // 当读入的数据个数为奇数时，输出此时读入数据的中位数
                if (i % 2 == 0){
                    System.out.print(findMedian() + " ");
                    if (++cnt % 10 == 0) System.out.println();
                }
            }
            if (cnt % 10 != 0) System.out.println();


        }
    }

    public static int findMedian() {

        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2;
    }
}
