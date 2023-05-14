package 数组链表练习题.双指针技巧.链表双指针;

/**
 *  https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    class Solution {
        public ListNode middleNode(ListNode head) {
            // 快慢指针初始化指向 head
            ListNode slow = head, fast = head;
            // 快指针走到末尾时停止
            while (fast != null && fast.next != null) { //快指针还没走到头
                // 慢指针走一步，快指针走两步
                slow = slow.next;
                fast = fast.next.next;
            }
            // 慢指针指向中点
            return slow;
        }
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
