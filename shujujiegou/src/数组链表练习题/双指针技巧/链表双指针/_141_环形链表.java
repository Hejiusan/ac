package 数组链表练习题.双指针技巧.链表双指针;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * 快慢指针的思想也可以用到判断链表是否存在环
 * fast走两步 slow走一步 如果fast能追上slow；说明有环
 */
public class _141_环形链表 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast !=null && fast.next!=null){ //还没走到头
                // 慢指针走一步，快指针走两步
                slow = slow.next;
                fast = fast.next.next;
                // 快慢指针相遇，说明含有环
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
