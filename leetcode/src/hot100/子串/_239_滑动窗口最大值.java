package hot100.子串;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        // 双端队列，允许两头都进，两头都出
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 如果队列中的第一个元素的索引已经不在当前窗口范围内（i - k + 1），则将其移除。
            // 移除队列中所有不在当前窗口的元素
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 移除队列中所有比当前元素小的元素
            //从队列的末尾开始，如果队列中的元素小于当前遍历到的元素 nums[i]，则将其移除，因为这些元素不可能在当前或之后的窗口中成为最大值。
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 将当前元素的索引添加到队列
            deque.offerLast(i);

            // 当滑动窗口的大小达到 k 时，记录当前窗口的最大值
            // 当遍历的索引 i 大于等于 k - 1 时，说明窗口已经形成（大小为 k），此时记录队列第一个元素对应的数组值为当前窗口的最大值。
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
