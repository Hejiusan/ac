package 回溯算法;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations-ii/description/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class _47_全排列II {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length]; // 用于记录元素是否被使用
        Arrays.sort(nums);
        backTracking(nums, path, used);
        return res;
    }

    private void backTracking(int[] nums, LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new LinkedList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素已经被使用，或者当前元素与前一个元素相同且前一个元素没有被使用，则跳过
            /**
             * !used[i - 1] 这里主要是防止生成相同的排列
             *  这是因为如果前一个相同的元素还没有被使用，那么它的排列还没有生成过，我们应该先生成前一个相同元素的排列。
             *  比如 [1,1,2] 在不加限制的情况下会生成
             * 	[1, 1, 2]
             * 	[1, 2, 1]
             * 	[1, 1, 2] (重复)
             * 	[1, 2, 1] (重复)
             * 	[2, 1, 1]
             * 	[2, 1, 1] (重复)
             */
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums, path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
