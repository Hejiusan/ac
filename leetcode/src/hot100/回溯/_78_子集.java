package hot100.回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class _78_子集 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(nums, path, 0);
        return res;
    }

    private void traverse(int[] nums, LinkedList<Integer> path, int startIndex) {
        res.add(new LinkedList<>(path));

        for (int i = startIndex; i < nums.length; i++) {

            path.add(nums[i]);
            // 确保不重复使用
            traverse(nums, path, i+1);
            path.removeLast();
        }
    }
}
