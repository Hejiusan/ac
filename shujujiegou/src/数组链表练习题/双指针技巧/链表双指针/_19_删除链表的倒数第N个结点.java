package 数组链表练习题.双指针技巧.链表双指针;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * 和求倒数第k个节点类似
 * 解法中在链表头部接一个虚拟节点 dummy 是为了避免删除倒数第一个元素时出现空指针异常，在头部加入 dummy 节点并不影响尾部倒数第 k 个元素是什么。
 *
 * 为了防止出现空指针的情况，比如说链表总共有 5 个节点，题目就让你删除倒数第 5 个节点，也就是第一个节点，
 * 那按照算法逻辑，应该首先找到倒数第 6 个节点。但第一个节点前面已经没有节点了，这就会出错
 */
public class _19_删除链表的倒数第N个结点 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;  //虚拟头节点
            ListNode prev = findFromEnd(dummy, n + 1);  //倒数第n+1个节点
            prev.next = prev.next.next;
            return dummy.next;
        }
        // 返回链表的倒数第 k 个节点
        ListNode findFromEnd(ListNode head, int k) {
            ListNode p1 = head;
            // p1 先走 k 步
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            // p1 和 p2 同时走 n - k 步
            while (p1 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            // p2 现在指向第 n - k 个节点
            return p2;
        }
    }
}
