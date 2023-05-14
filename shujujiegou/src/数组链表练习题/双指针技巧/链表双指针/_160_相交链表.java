package 数组链表练习题.双指针技巧.链表双指针;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * <p>
 * 如果用两个指针 p1 和 p2 分别在两条链表上前进，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，
 * <p>
 * 让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
 * <p>
 * 如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1：
 */
public class _160_相交链表 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // p1 指向 A 链表头结点，p2 指向 B 链表头结点
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                // p1 走一步，如果走到 A 链表末尾，转到 B 链表
                if (p1 == null) p1 = headB;
                else p1 = p1.next;
                // p2 走一步，如果走到 B 链表末尾，转到 A 链表
                if (p2 == null) p2 = headA;
                else p2 = p2.next;
            }
            return p1;
        }
    }
}
