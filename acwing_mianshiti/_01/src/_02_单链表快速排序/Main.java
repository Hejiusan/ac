package _02_单链表快速排序;

class Main {
    public ListNode quickSortList(ListNode head) {
        if (head == null || head.next == null)    return head;
        // 三个子链表分别存储 小于 等于和大于的部分 在合并
        ListNode left = new ListNode(-1);
        ListNode mid = new ListNode(-1);
        ListNode right = new ListNode(-1);
        // 还需要定义对应的尾指针
        ListNode ltail = left, mtail = mid, rtail = right;
        int val = head.val;
        // 遍历链表
        for (ListNode p = head; p != null; p=p.next) {
            if (p.val < val){
                ltail.next = p;
                ltail = ltail.next; // 尾指针往后移
            }
            else if (p.val == val)  {
                mtail.next = p;
                mtail = mtail.next;
            }
            else {
                rtail.next = p;
                rtail = rtail.next;
            }
        }
        // 让他们尾节点都指向null
        ltail.next = mtail.next = rtail.next = null;
        // 递归处理两边
        // left和right是虚拟头节点 所以他们的next指向的就是链表里的元素
        left.next = quickSortList(left.next);
        right.next = quickSortList(right.next);
        // 拼接三个链表
        getTail(left).next = mid.next;
        // 因为mid链表是可能不存在的 ，但是left链表一定存在 所以left在拼接完mid后再去next拼接上right
        getTail(left).next = right.next;
        return left.next;
    }

    private ListNode getTail(ListNode head) {
        while (head.next != null)   head = head.next;
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


