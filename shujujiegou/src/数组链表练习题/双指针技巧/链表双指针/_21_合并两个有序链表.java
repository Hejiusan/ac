package 数组链表练习题.双指针技巧.链表双指针;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 虚拟头结点
            ListNode dummy = new ListNode(-1), p = dummy;   //p指针指向虚拟头节点
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    p.next = list2;
                    list2 = list2.next;
                } else {
                    p.next = list1;
                    list1 = list1.next;
                }
                //p指针不断向前走
                p = p.next;
            }
            //如果一方走到头了 另一方直接补上
            if (list1 != null) {
                p.next = list1;
            }
            if (list2 != null) {
                p.next = list2;
            }
            return dummy.next;  //虚拟头节点的next  也就是整个链表
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
