package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum-iii/description/
 *
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class _216_组合总和III {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(path,k, n, 1);
        return res;
    }

    private void backtrack(LinkedList<Integer> path, int k, int n,  int start) {
        // 结束条件
        if (path.size() == k){
            int sum = 0;
            for (Integer i : path) {
                sum+=i;
            }
            if (sum == n){
                res.add(new LinkedList<>(path));
                return;
            }
        }
        //在递归调用 backtrack 方法时，传递 i + 1 作为新的 start 参数，确保每个组合中的数字是严格递增的，从而避免重复的组合。
        for (int i = start; i < 10; i++) {
            path.add(i);
            // 进入下一层
            backtrack(path, k, n, i + 1);
            // 撤销操作
            path.removeLast();
        }
    }
}
