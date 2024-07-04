package hot100.链表;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class _24_两两交换链表中的节点 {
    /**
     * 递归交换两两相邻节点, 返回
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // 如果链表为空，或者链表就一个节点 直接return
        if (head == null || head.next == null)  return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode others = head.next.next;

        // 交换前两个
        second.next = first;
        // 继续交换剩下的
        first.next = swapPairs(others);

        return second;
    }
}
