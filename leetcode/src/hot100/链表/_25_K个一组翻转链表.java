package hot100.链表;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //区间长度为k
        ListNode a,b;
        a = b = head;
        // b指针移动到第 k 个位置
        for (int i = 0; i < k; i++) {
            if (b == null)  return head;
            b = b.next;
        }
        // 交换[a,b) 区间内的链表元素
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b, k) ;   // 递归下一组
        return newHead;
    }

    /**
     * 递归翻转链表
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        // 初始化
        pre = null;
        cur = a;
        nxt = a;
        // 直到 cur指针移动到了b位置
        while (cur != b){
            nxt = cur.next; // 保存当前节点的下一个节点
            cur.next = pre; // 实现翻转，将next指向他的前一个节点
            // 移动指针   下一个要反转的 节点变成了 cur 和 原本的cur.next
            pre = cur;  // 移动指针，
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}
