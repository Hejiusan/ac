package 数组链表练习题.双指针技巧;

/**
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 思路：
 * 首先，我们先让一个指针 p1 指向链表的头节点 head，然后走 k 步：P1还需要走n-k步到达链表末尾空指针
 * 这时，我们用一个新指针p2也指向head，他俩同时动，当p1-》null时，p2刚好走到了n-k+1个位置：也就是链表倒数第k个节点
 */
public class 剑指Offer_22_链表中倒数第k个节点 {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode p1 = head;
            while (k-- > 0) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
