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
            ListNode p1 = list1, p2 = list2;                    // 这样便于理解  p既是节点，也起到了指针的作用
            while (p1 != null && p2 != null) {
                if (p1.val > p2.val) {
                    p.next = list2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }
                //p指针不断向前走
                p = p.next;
            }
            //如果一方走到头了 另一方直接补上
            if (p1 != null) {
                p.next = p1;
            }

            if (p2 != null) {
                p.next = p2;
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
