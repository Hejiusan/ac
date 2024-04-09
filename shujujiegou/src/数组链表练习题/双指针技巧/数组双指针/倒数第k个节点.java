package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/submissions/521923401/
 */
public class 倒数第k个节点 {

    public int kthToLast(ListNode head, int k) {
        ListNode p1 = head; // p1指向头结点
        // P1先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        // p1 p2一起走 当p1指向null  p2恰好停在n-k+1的位置
        while (p1!=null){
            p2=p2.next;
            p1=p1.next;
        }
        return p2.val;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

