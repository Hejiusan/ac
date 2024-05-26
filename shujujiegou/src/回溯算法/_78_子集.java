package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/description/
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

 */
public class _78_子集 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backTracking(nums, path, 0);
        return res;
    }

    private void backTracking(int[] nums, LinkedList<Integer> path, int start) {
        res.add(new LinkedList<>(path));  // 空也是一个子集
        for (int i = start; i < nums.length; i++) {
            // 做选择
            path.add(nums[i]);
            // 回溯
            backTracking(nums, path, i + 1);    // 不重复使用，所以从i+1开始
            path.removeLast();

        }
    }
}
