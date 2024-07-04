package 数组链表练习题.递归反转单链表;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class _25_K个一组翻转链表 {
    /**
     * 反转以 head 开头的 k 个元素。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        // b指针移到末尾
        for (int i = 0; i < k; i++) {
            // base case
            // 不足 k 个，不需要反转，直接返回
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);

        return newHead;
    }

    /* 反转区间 [a, b) 的元素，注意是左闭右开 */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; // 存储前一个节点
        cur = a;    // 存储当前节点
        nxt = a;    // 用于存储下一个节点
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next; // 保存当前节点的下一个节点
            cur.next = pre; // 将当前节点的 next 指针指向前一个节点，实现反转。
            pre = cur;  // 移动 pre 指针到当前节点。
            cur = nxt;  // 移动 cur 指针到下一个节点。
        }
        // 返回反转后的头结点
        return pre;
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
