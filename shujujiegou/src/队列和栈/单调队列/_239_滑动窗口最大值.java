package 队列和栈.单调队列;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满第一个窗口
                window.push(nums[i]);
            } else {
                // 窗口开始滑动
                // 移入新元素
                window.push(nums[i]);
                // 将当前窗口中的最大元素 加入 结果
                res.add(window.max());
                // 移除最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        // 将List 转为int[]类型返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
