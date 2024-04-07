package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); //虚拟头结点 简化边界问题
        ListNode p = dummy;

        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null){
            // 双指针分别比较大小
            if (p1.val > p2.val){
                p.next = p2;
                p2=p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            // p指针不断向前
            p = p.next;
        }
        // 如果有一方走到头了 直接补上
        if (p1 !=null){
            p.next = p1;
        }
        if (p2 !=null){
            p.next = p2;
        }
        return dummy.next;
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
