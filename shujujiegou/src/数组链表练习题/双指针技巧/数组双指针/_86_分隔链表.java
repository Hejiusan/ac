package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/partition-list/description/
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有
 * 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class _86_分隔链表 {

    public ListNode partition(ListNode head, int x) {
        // 分成俩条链表 所以要俩个虚拟头结点
        // 存放小于x的链表
        ListNode dummy1 = new ListNode(-1);
        // 存放大于x的链表
        ListNode dummy2 = new ListNode(-1);

        // p1 p2作为指针
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        // p 指向原链表
        ListNode p = head;
        while (p != null){
            if (p.val >= x){
                p2.next = p;
                p2 = p2.next;
            }else {
                p1.next = p;
                p1 = p1.next;
            }
            // 不能直接让p指针前进
            // 要断开原链表中的每个节点的next指针  不然就成环啦！！ 链表不能有环
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        // 链接两个链表
        p1.next = dummy2.next;
        return dummy1.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
