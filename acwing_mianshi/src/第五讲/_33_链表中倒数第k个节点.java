package 第五讲;

/**
 * https://www.acwing.com/problem/content/32/
 * 输入一个链表，输出该链表中倒数第 k 个结点。
 *
 * 输入：链表：1->2->3->4->5 ，k=2
 */
public class _33_链表中倒数第k个节点 {
    /*
    思路：fast指针先走k步，然后slow指针从起点开始，当fast走到null了，slow恰好走到倒数第k个位置
     */
    public ListNode findKthToTail(ListNode pListHead, int k) {
        if (pListHead == null){
            return null;
        }
        // 定义虚拟头结点防止空指针，比如6个点 问倒数第六个点，就会空指针
        ListNode fast = new ListNode(-1);
        ListNode slow = new ListNode(-1);
        fast.next = pListHead;
        slow.next = pListHead;
        for (int i = 0; i < k; i++) {
            if (fast.next == null){
                return null;
            }
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
