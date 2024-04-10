package 数组链表练习题.递归反转单链表;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);

        head.next.next = head;

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
