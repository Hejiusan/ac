package hot100.链表;

/**
 * https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1, p2 = l2;
        // 要生成一个新链表，所以定义一个虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int s = 0;  // 进位
        while (p1 != null || p2 != null || s > 0){
            int val = s;    // 先加上上次的进位
            if (p1 != null){
                val += p1.val;
                p1 = p1.next;   // 指针也得往后移
            }
            if (p2 != null){
                val += p2.val;
                p2 = p2.next;   // 指针也得往后移

            }
            p.next = new ListNode(val % 10);    // 这里是指针的作用
            p = p.next; //指针往后移
            s = val / 10;   // 计算进位
        }
        return dummy.next;

    }
}
