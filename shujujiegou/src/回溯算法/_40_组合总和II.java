package 回溯算法;

import java.util.Arrays;
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
        Arrays.sort(candidates);    // 对候选数组进行排序
        LinkedList<Integer> path = new LinkedList<>();
        boolean used[] = new boolean[candidates.length];
        backTraverse(candidates, target, path, 0, used);
        return res;
    }

    private void backTraverse(int[] candidates, int target, LinkedList<Integer> path, int start, boolean used[]) {
        if (sum > target)
            return;
        if (sum == target) {
            res.add(new LinkedList<>(path));
        }

        // 因为有重复的元素，在不同的路径里取了这些元素，但是因为值大小相同的原因，导致出现重复
        // 所以需要剪枝，如果一个系节点有多条值相同的树枝相邻，剩下的都剪掉
        // 所以需要先进行排序


        for (int i = start; i < candidates.length; i++) {
            // 对于相同值的元素，如果有相邻的就剪掉
            if (i > start && candidates[i] == candidates[i-1])
                continue;
            // 已经走过的就排除
            if (used[i])
                continue;
            path.add(candidates[i]);
            used[i] = true;
            sum += candidates[i];
            backTraverse(candidates, target, path, i + 1, used);    // 递归时，start索引从i+1开始，确保不重复使用相同元素
            path.removeLast();
            used[i] = false;
            sum -= candidates[i];
        }
    }
}
