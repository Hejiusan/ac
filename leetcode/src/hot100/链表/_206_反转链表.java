package hot100.链表;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class _206_反转链表 {
    /**
     * 递归思想
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 递归的结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 这里反转的是当前节点的后续节点
        ListNode newHead = reverseList(head.next);
        // 将当前节点的 next 节点的 next 指向当前节点。
        head.next.next = head;  // 也就是让当前 的后续节点反转之后 在继续指向当前节点 实现了全部的反转
        // 断开当前节点的next
        head.next = null;
        return newHead;
    }
}
