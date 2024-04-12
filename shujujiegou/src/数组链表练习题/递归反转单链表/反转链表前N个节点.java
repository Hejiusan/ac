package 数组链表练习题.递归反转单链表;

public class 反转链表前N个节点 {

    // 之前反转整个链表时，直接把 head.next 设置为 null，因为整个链表反转后原来的 head 变成了整个链表的最后一个节点。
    // 但现在 head 节点在递归反转之后不一定是最后一个节点了，所以要记录后驱 successor（第 n + 1 个节点），反转之后将 head 连接上。
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点 （n <= 链表长度）
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
