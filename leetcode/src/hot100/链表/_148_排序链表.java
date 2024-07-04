package hot100.链表;

/**
 * https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class _148_排序链表 {
    /**
     * 链表最适合归并排序。可以运用递归的思想  时间复杂度为 nlogn
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 基本情况：如果链表为空或只有一个节点，则它已经是有序的
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到链表的中间节点
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 循环结束，slow走到了中间；通过prev指针来起到断开链表的作用
        // 断开链表
        prev.next = null;

        // 递归排序两半
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 合并两半
        return merge(l1, l2);
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        // 剩下没走到头的 直接补上
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }

}
