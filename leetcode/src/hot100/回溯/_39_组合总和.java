package hot100.回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class _39_组合总和 {
    List<List<Integer>> res = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(candidates, path, 0, target);
        return res;
    }

    private void traverse(int[] candidates, LinkedList<Integer> path, int start, int target) {
        // 不满足条件的直接剪枝
        if (sum > target)
            return;
        if (sum == target){
            res.add(new LinkedList<>(path));
        }
        // 从start索引开始遍历，这样当回溯的时候，前面选过的索引就不会再选了，
        // [2,3,6,7] target = 7  防止出现 223   322这种重复情况，回溯到后面去了 就不能再选前面的
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            // 回溯
            traverse(candidates, path, i, target);
            // 撤销选择
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
