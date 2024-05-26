package 回溯算法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets-ii/description/
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class _90_子集II {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums); // 对数组进行排序
        backTracking(nums, path, 0);
        return res;
    }

    private void backTracking(int[] nums, LinkedList<Integer> path, int start) {
        res.add(new LinkedList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 如果存在相邻重复元素，跳过. 注意这里 i > start 不能简单的i>1 这会导致元素重复时，后面的子集没加进去
            // i > start 确保走到了所有子集
            if (i > start  &&nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backTracking(nums, path, i + 1);    // 对于相邻的重复元素，会产生重复的子集，所以需要进行排序以及判别是否存在相邻重复元素
            path.removeLast();
        }
    }
}
