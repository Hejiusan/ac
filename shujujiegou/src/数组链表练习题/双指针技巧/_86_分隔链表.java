package 数组链表练习题.双指针技巧;

/**
 * https://leetcode.cn/problems/partition-list/
 */
public class _86_分隔链表 {
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

    static class Solution {
        public static ListNode partition(ListNode head, int x) {
            // 存放小于 x 的链表的虚拟头结点
            ListNode dummy1 = new ListNode(-1);
            // 存放大于等于 x 的链表的虚拟头结点
            ListNode dummy2 = new ListNode(-1);
            // p1, p2 指针负责生成结果链表    dummy是固定在那的虚拟头节点，p1 p2既是节点也起到了指针的作用
            ListNode p1 = dummy1, p2 = dummy2;
            // p 负责遍历原链表，类似合并两个有序链表的逻辑
            // 这里是将一个链表分解成两个链表
            ListNode p = head;
            while (p != null) {
                if (p.val >= x) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }
                // 断开原链表中的每个节点的 next 指针
                // 这里不断掉会成环 Error - Found cycle in the ListNode
//                ListNode temp = p.next;
//                p.next = null;
//                p = temp;
                p=p.next;
            }
            // 链接两个链表
            //为啥会成环，因为在链接两个链表的时候，p2中的节点2还保存了指向1的next指针，导致成环 所以我们需要在每保存一个节点的时候都需要断开原节点指向
            p1.next = dummy2.next;

            return dummy1.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        Solution.partition(head,2);
    }
}
