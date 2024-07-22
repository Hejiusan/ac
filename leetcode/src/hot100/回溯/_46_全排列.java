package hot100.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * for 选择 in 选择列表:
 *  *     # 做选择
 *  *     将该选择从选择列表移除
 *  *     路径.add(选择)
 *  *     backtrack(路径, 选择列表)
 *  *     # 撤销选择
 *  *     路径.remove(选择)
 *  *     将该选择再加入选择列表
 */
public class _46_全排列 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        traverse(nums, path, used);
        return res;
    }

    private void traverse(int[] nums, LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 已经走过的就排除
            if (used[i])
                continue;
            // 做选择
            path.add(nums[i]);
            used[i] = true;
            traverse(nums, path, used);
            // 撤销选择
            path.removeLast();
            used[i] = false;

        }
    }
}
