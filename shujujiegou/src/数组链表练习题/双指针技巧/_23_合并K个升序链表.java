package 数组链表练习题.双指针技巧;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * 合并 k 个有序链表的逻辑类似合并两个有序链表，难点在于，如何快速得到 k 个节点中的最小节点，接到结果链表上？
 * 这里我们就要用到 优先级队列（二叉堆） 这种数据结构，把链表节点放入一个最小堆，就可以每次获得 k 个节点中的最小节点：
 */
public class _23_合并K个升序链表 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int k = lists.length;
            if (k == 0) return null;
            //定义虚拟头节点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy; //指针作用
            // 优先级队列，最小堆    a-b最小堆  b-a最大堆
            PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    lists.length, (a, b) -> (a.val - b.val));
            //把lists里面的每个链表的头节点存进去优先队列
            for (ListNode head : lists) {
                if (head != null)
                    pq.add(head);
            }

            while (!pq.isEmpty()) {
                // 因为优先队列实现形式为最小堆 ==> 默认根节点元素为最小值
                // 获取最小节点，接到结果链表中
                ListNode node = pq.poll();
                p.next = node;  //存进新链表
                //如果优先队列中存的子链表还有元素，继续入队
                if (node.next != null) {
                    pq.add(node.next);
                }
                //p指针不断往后移
                p = p.next;
            }
            return dummy.next;

        }
    }
}
