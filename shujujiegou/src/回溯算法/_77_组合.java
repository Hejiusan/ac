package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/description/
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class _77_组合 {
    /*
    思路：
    从1开始遍历，防止用到重复的数，递归到下一层是 start + 1


     */
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        backTraverse(n,path,1,k);
        return res;
    }

    private void backTraverse(int n, LinkedList<Integer> path, int start, int k) {
        if (path.size() == k){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {  // 防止出现顺序不同的重复值 start来记录下一层递归，搜索的起始位置
        // 剪枝可以优化, 少走一些路径
//        for (int i = start; i <= n - (k - path.size()) + 1; i++){

            path.add(i);
            backTraverse(n,path,i+1,k);
            // 撤销选择
            path.removeLast();
        }
    }
}
