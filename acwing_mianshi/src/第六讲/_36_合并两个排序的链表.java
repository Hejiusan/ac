package 第六讲;

/**
 * https://www.acwing.com/problem/content/34/
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 */
public class _36_合并两个排序的链表 {
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1!=null && p2!=null){
            if (p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2= p2.next;
            }
            p = p.next; // P指针也往后移
        }
        if (p1 != null){
            p.next = p1;
        }
        if (p2!=null){
            p.next = p2;
        }
        return dummy.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
