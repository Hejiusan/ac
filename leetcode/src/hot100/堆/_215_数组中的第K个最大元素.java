package hot100.堆;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 */
public class _215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆，堆顶是最小元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);  // 每个元素进入小顶堆都会自动筛选，把最小的放在堆顶
            if (pq.size() > k){
                // 当堆里的元素为k个时，堆顶元素就是第k大的了
                // 多余的删掉
                pq.poll();
            }
        }
        return pq.peek();
    }

}
