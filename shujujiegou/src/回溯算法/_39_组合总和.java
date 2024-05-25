package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/description/
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class _39_组合总和 {
    List<List<Integer>> res = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        backTraverse(candidates, target, path, 0);
        return res;
    }

    private void backTraverse(int[] candidates, int target, LinkedList<Integer> path, int start) {
        if (sum > target) { // 剪枝操作
            return;
        }
        if (sum == target){
            res.add(new LinkedList<>(path));
        }
        // 元素无重可复选
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTraverse(candidates, target, path, i);  // 这里start改为i，那么元素就可以复选了，但是因为是i 随着i增大，以前的值不会被选到，所以不会出现，122，221这种重复情况了
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
