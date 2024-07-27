package 第一讲;

/**
 * https://www.acwing.com/problem/content/86/
 * <p>
 * 给定一个链表，若其中包含环，则输出环的入口节点。
 * <p>
 * 若其中不包含环，则输出null。
 */
public class _34_链表中环的入口结点 {
    public ListNode entryNodeOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)   break;  // 快慢指针相遇
        }
        if (fast == null || fast.next == null){
            // fast遇到空，说明不包含环
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
