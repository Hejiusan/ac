package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum-ii/description/
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * 元素重复，不可复选
 */
public class _40_组合总和II {
    List<List<Integer>> res = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        backTraverse(candidates, target, path, 0);
        return res;
    }

    private void backTraverse(int[] candidates, int target, LinkedList<Integer> path, int start) {
        if (sum > target)
            return;
        if (sum == target) {
            res.add(new LinkedList<>(path));
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTraverse(candidates, target, path, start + 1);
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
