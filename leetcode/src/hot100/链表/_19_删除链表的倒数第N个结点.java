package hot100.链表;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class _19_删除链表的倒数第N个结点 {
    /*
    要删除倒数第n个节点，就得找到倒数第 n+1个索引  让n+1 .next = next.next
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 定义一个虚拟头结点，防止空指针，比如5个节点删除倒数第五个节点，我们就要找到倒数第六个节点，避免了空指针
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 先找到倒数第 n+1 个节点
        ListNode x = findNode(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;
    }

    private ListNode findNode(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p2从起点和p1一起走，p1到尾部，p2 和 p1隔了k个位置，也就是倒数第k个位置
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
