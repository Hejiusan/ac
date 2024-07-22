package hot100.链表;

/**
 * https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class _148_排序链表_copy {
    /**
     * 单链表快速排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) {
            return head;
        }

        ListNode pivot = head;  // 和头结点元素进行比较
        ListNode slow = head;   // slow用来交换值  确定小于 pivot 的区域
        ListNode fast = head.next;  // fast指针用来遍历链表
        while (fast != end){
            if (fast.val < pivot.val){  // 小于就得交换
                slow = slow.next;   // slow当前指向的就是小于pivot的，所以继续存的话，需要往后移
                int temp = slow.val;
                slow.val = fast.val;
                fast.val = temp;
            }
            fast = fast.next;   // 继续遍历
        }
        // 遍历结束后，将 pivot 的值与 slow 当前指向节点的值进行交换。
        // 通过这一步，pivot 值会被放到正确的位置上，左边的值都小于 pivot，右边的值都大于或等于 pivot
        int temp = pivot.val;
        pivot.val = slow.val;
        slow.val = temp;
        // 对 pivot 左边和右边进行排序
        quickSort(head, slow);
        quickSort(slow.next, end);

        return head;
    }


}
