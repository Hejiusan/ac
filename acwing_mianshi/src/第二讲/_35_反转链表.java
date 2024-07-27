package 第二讲;

public class _35_反转链表 {
    /*
     迭代版本: 用一个变量来存当前节点的前一个节点，让当前节点指向他的prev， prev变成新的当前节点, 并指向原cur 的next节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null){
            temp = cur.next;
            cur.next = prev;    // 实现反转
            // 这里其实是指针的移动
            prev = cur; // 将prev更新成当前节点，也就是实现了prev指针的向后移动
            cur = temp; // 更新cur， 移动cur指针
        }
        return prev;
    }
    /*
    递归版本：将「以 head 为起点」的链表反转，并返回反转之后的头结点。
    1->2->3->4->5
              1
              ↓
    （5->4->3->2）->空

     */
    public ListNode reverseList2(ListNode head) {
        // 递归的结束条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;  // 这里就是 1->2->空 ==》 1->2->1
        // 在把1->2 给断开
        head.next = null;
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
