package hot100.链表;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 */
public class _160_相交链表 {
    /*
    A+B链表的长度一定等于 B+A链表的长度  所以一定会同时遍历到结尾
    两个指针p1 p2分别指向两个链表的头结点，p1遍历完链表A就去遍历链表B   p2遍历完链表B就去遍历链表A （逻辑上使得两条链表接在了一起）
    如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1：
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1!=p2){
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // 同理
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        // p1 = p2 了 指向同一个位置
        return p1;
    }
}




