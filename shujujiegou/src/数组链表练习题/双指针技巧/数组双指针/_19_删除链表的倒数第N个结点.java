package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class _19_删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点避免空指针
        /**
         *  ⽐如说链表总共有 5 个节点，
         *  题⽬就让你删除倒数第 5 个节点，也就是第⼀个节点，那按照算法逻辑，应该⾸先找到倒数第 6 个节点。
         *  但第⼀个节点前⾯已经没有节点了，
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //先找到倒数第 n+1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1!=null){
            p2= p2.next;
            p1 = p1.next;
        }

        return p2;
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
