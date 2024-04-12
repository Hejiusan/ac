package 数组链表练习题.双指针技巧.链表双指针;

import 数组链表练习题.双指针技巧.链表双指针.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * 和数组去除重复元素类似，只是将索引换成了指针
 */
public class _83_删除排序链表中的重复元素 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            //Dereference of 'slow' may produce 'NullPointerException'
            if (head == null) return null;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    // nums[slow] = nums[fast];
                    slow.next = fast;
                    // slow++;
                    slow = slow.next;
                }
                fast = fast.next;
            }
            //断开与后面重复元素的连接
            slow.next = null;
            // fast、slow起的是指针的作用，修改了head这个链表，返回的还是原链表
            return head;
        }
    }
}
