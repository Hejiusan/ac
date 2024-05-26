package 回溯算法;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/non-decreasing-subsequences/description/
 *
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class _491_非递减子序列 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backTracking(nums, path, 0);
        return res;
    }

    // 回溯算法主函数
    private void backTracking(int[] nums, LinkedList<Integer> path,int start) {
        if (path.size() >= 2) {
            // 找到一个合法答案
            res.add(new LinkedList<>(path));
        }
        // 用哈希集合防止在当前层里重复选择相同元素
        HashSet<Integer> used = new HashSet<>();
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 保证集合中元素都是递增顺序
            //// 如果当前元素小于路径中最后一个元素，或者当前元素已经在当前层用过了，则跳过
            if (!path.isEmpty() && path.getLast() > nums[i] || used.contains(nums[i])) {
                continue;
            }

            // 选择 nums[i]
            used.add(nums[i]);
            path.add(nums[i]);
            // 递归遍历下一层回溯树
            backTracking(nums, path, i + 1);
            // 撤销选择 nums[i]
            path.removeLast();
        }
    }
}
