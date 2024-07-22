package _02_单链表快速排序;

import java.util.Scanner;

/**
 * 给定一个单链表，请使用快速排序算法对其排序。
 *
 * 要求：期望平均时间复杂度为 O(nlogn)
 * ，期望额外空间复杂度为 O(logn)
 */
class Solution {
    public ListNode quickSortList(ListNode head) {
        // 如果链表为空或者只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) {
            return head;
        }

        // 分区操作  三个指针
        // pivot 被选择为头节点（head），slow 指针用于确定小于 pivot 的区域。 fast 指针用于遍历链表。
        ListNode pivot = head;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != end) {
            if (fast.val < pivot.val) { // 小于的放到pivot左边
                // 将 slow 前进一步并交换 slow 和 fast 的值。
                slow = slow.next;
                // 交换 slow 和 fast 的值
                int temp = slow.val;
                slow.val = fast.val;
                fast.val = temp;
            }
            fast = fast.next;
        }
        // 上面循环结束之后，slow指向的是最后一个小于等于pivot的值
        // pivot只是一个基准值，他的指针并没有移动, 所以他一直都是在head的位置。
        // 因为需要通过和slow交换使得他位于正确的位置，slow原本的位置也是小于pivot的，交换之后还是在她左边
        int temp = pivot.val;
        pivot.val = slow.val;
        slow.val = temp;


        // 对 pivot 左边和右边进行排序
        quickSort(head, slow);
        quickSort(slow.next, end);

        return head;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

}


