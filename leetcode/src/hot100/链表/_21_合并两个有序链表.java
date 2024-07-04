package hot100.链表;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 拼接成一个新的链表，定义一个虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;   //p指针指向虚拟头节点
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            //p指针不断向前走
            p=p.next;
        }
        if (list1 != null){
            p.next = list1;
        }else {
            p.next = list2;
        }
        return dummy.next;  //不 next的话会多个头结点 -1
    }
}
