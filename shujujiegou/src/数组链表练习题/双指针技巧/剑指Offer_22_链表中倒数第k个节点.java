package 数组链表练习题.双指针技巧;

/**
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class 剑指Offer_22_链表中倒数第k个节点 {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast!=null && fast.next!=null){
                for (int i = 0; i < k; i++) {
                    fast = fast.next;
                }
                slow = slow.next;
            }
            return slow.next;
        }
    }

     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

}
