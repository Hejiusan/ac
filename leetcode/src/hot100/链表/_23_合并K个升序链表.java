package hot100.链表;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class _23_合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        // 开始合并成一个新链表
        ListNode dummy = new ListNode(-1);  // 初始化虚拟头结点
        ListNode p = dummy;
        // 优先级队列 已经会将元素进行排序，此时队头元素就是最小值
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null){
                pq.add(node.next);  // node的next作为新的头结点入队
            }
            p = p.next; // p指针不断后移
        }
        return dummy.next;

    }
}
