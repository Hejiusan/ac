package hot100.链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 */
public class _234_回文链表 {
    /*
    暴力：回文就是前后遍历一致
    直接将链表存入数组，然后用数组的双指针，从两端开始遍历来确认

    也可以用双指针的思想：使用快慢指针找到链表的中点，然后反转后半部分链表，最后比较前半部分和反转后的后半部分
     */
    public boolean isPalindrome(ListNode head) {
        // 注意要使用ArrayList而不是LinkedList；因为前者是基于数组来实现的，随机访问元素的复杂度为O(1) 而LinkedList基于链表
        List<Integer> list = new ArrayList<>();
        ListNode curNode = head;
        while (curNode != null){
            list.add(curNode.val);
            curNode = curNode.next;
        }
        // 双指针
        int front = 0;
        int back = list.size() - 1;
        while (front < back){
            if (!list.get(front).equals(list.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;

    }
    public boolean isPalindrome2(ListNode head){
        // 使用快慢指针找到链表的中点
        /**
         * 使用快慢指针法，快指针每次移动两步，慢指针每次移动一步，当快指针到达链表末尾时，慢指针刚好到达链表中点。
         * 如果链表长度是奇数，让慢指针再走一步，跳过中间节点。
         */
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果链表长度是奇数，让 slow 再走一步
        if (fast != null) {
            slow = slow.next;
        }

        // 反转后半部分链表
        slow = reverseList(slow);
        fast = head;
        // 比较前半部分和反转后的后半部分
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
