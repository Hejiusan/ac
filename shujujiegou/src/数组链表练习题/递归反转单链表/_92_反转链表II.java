package 数组链表练习题.递归反转单链表;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class _92_反转链表II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left==1){   //相当于反转前n个元素
            return reverseN(head, right);
        }
        // 前进到反转的起点触发 base case
        // head.next指向的链表进行翻转，相当于起点+1 也就是l和r都要-1
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {

        if (n == 1) {   // 反转一个元素 就是本身
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        // 1->2->3->4->5  head:1  若n=3
        // 1-><-2<-3
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;  // 3->2->1->successor
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
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
