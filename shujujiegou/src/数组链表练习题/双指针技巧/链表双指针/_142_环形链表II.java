package 数组链表练习题.双指针技巧.链表双指针;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 *
 * 我们假设快慢指针相遇时，慢指针 slow 走了 k 步，那么快指针 fast 一定走了 2k 步：
 * fast 一定比 slow 多走了 k 步，这多走的 k 步其实就是 fast 指针在环里转圈圈，所以 k 的值就是环长度的「整数倍」。
 *
 * 假设相遇点距环的起点的距离为 m，那么结合上图的 slow 指针，环的起点距头结点 head 的距离为 k - m，也就是说如果从 head 前进 k - m 步就能到达环起点。
 *
 * 巧的是，如果从相遇点继续前进 k - m 步，也恰好到达环起点。
 *
 * 因此可以得出，当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。
 *
 */
public class _142_环形链表II {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast !=null && fast.next!=null){ //还没走到头
                // 慢指针走一步，快指针走两步
                slow = slow.next;
                fast = fast.next.next;
                // 快慢指针相遇，说明含有环
                if (slow == fast) break;
            }
            //链表无环 返回null
            if (fast == null || fast.next == null) {
                // fast 遇到空指针说明没有环
                return null;
            }
            //重新指向头节点
            slow = head;
            while (slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

        }
    }
}
