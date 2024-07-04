package hot100.链表;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class _142_环形链表II {
    /*
    我们假设快慢指针相遇时，慢指针 slow 走了 k 步，那么快指针 fast 一定走了 2k 步：
    相遇代表有环，假设环的起点到相遇点的距离为m，那么从链表头结点到环的起点的距离就是 k-m
    同时，相遇点继续往前走到环的起点的距离也是 k-m  因为fast多走的k步就是在环里转，环起点到相遇点距离为m，那么从相遇点走到环起点的距离就也是k-m
    这意味着，将slow移动头结点，让他俩在走k-m步，他们一定会在环起点相遇
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)   break;  // 说明有环 且遇上了
        }
        // 也可能fast走到头了，说明没有环
        //链表无环 返回null
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }
        slow = head;    // 将slow回到头结点，齐头并进在走k-m步
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
