package 数组链表练习题.递归反转单链表;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class _206_反转链表 {

    /**
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     * 反转之后的头结点也就是原链表的尾节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 1->2->3->4->null
        if (head == null || head.next == null) {
            return head;
        }
        // 1->rev(2->3->4) ===>  1-> 2 <-3 <- 4       1: head  4: last
        //                           ↓
        //                          null
        ListNode last = reverseList(head.next);

        // 1->2->null == 1  ==>  链上了 2->1
        head.next.next = head;

        // 断开 1->2  此时链表就翻转了 4->3->2->1
        head.next = null;

        return last;
    }

    public static class ListNode {
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
