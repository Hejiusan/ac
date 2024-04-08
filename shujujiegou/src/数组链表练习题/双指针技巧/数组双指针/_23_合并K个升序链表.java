package 数组链表练习题.双指针技巧.数组双指针;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class _23_合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;
        // 初始化虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 定义一个优先队列 来存储根节点 它会自动排序 从而找出最小的那个根节点
        //new PriorityQueue<>(capacity, comparator)  a-b 最小堆  b-a 最大堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b)->(a.val - b.val));
        // 将k个链表的头结点加入优先队列
        for (ListNode head : lists) {
            if (head!=null)
                pq.add(head);
        }

        while (!pq.isEmpty()){
            // 获取最小节点，接入链表
            ListNode node = pq.poll();
            p.next = node;
            // 第二个节点再次入优先队列 注意判空
            if (node.next != null)
                pq.add(node.next);

            p = p.next;  //p指针继续前进
        }

        return dummy.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
