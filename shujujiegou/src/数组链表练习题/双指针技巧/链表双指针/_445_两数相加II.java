package 数组链表练习题.双指针技巧.链表双指针;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/description/?show=1
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * <p>
 * 和前面两数相加类似，但是这里因为是高位在前，所以可以通过翻转链表的方式在进行相加
 * 也可以借助栈先进后出的思想
 */
public class _445_两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode p = dummy;
        // 记录进位
        int carry = 0;
        // 把元素加入栈中
        Stack<Integer> s1 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> s2 = new Stack<>();
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int val = carry;
            if (!s1.isEmpty()) {
                val += s1.pop();
            }
            if (!s2.isEmpty()) {
                val += s2.pop();
            }
            carry = val / 10;
            val = val % 10;
//            p.next = new ListNode(val);
//            p = p.next;
            // 构建新节点，直接接在 dummy 后面  因为这里是高位在前，所以加上后也高位在前
            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }
}
