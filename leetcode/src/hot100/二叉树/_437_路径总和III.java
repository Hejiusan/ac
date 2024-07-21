package hot100.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class _437_路径总和III {
    /*
    前缀和+深搜的思想：
    1、使用一个哈希表记录从根节点到当前节点的所有路径和
    2、对每个节点但进行DFS遍历，在遍历过程中计算当前路径的前缀和，并在并在哈希表中记录每个前缀和出现的次数。
    3、对于每个节点，检查从根节点到当前节点的路径和减去目标和 targetSum 是否已经存在于哈希表中，
        如果存在，说明存在一条从某个祖先节点到当前节点的路径，其和等于 targetSum。
    4、遍历完当前节点后，回溯时要将当前路径和从哈希表中删除，以避免影响其他路径的计算。
     */
    public int pathSum(TreeNode root, int targetSum) {
        // 使用哈希表记录前缀和
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // 初始化前缀和为 0 的数量为 1
        prefixSumCount.put(0L, 1);
        // 返回从根节点开始的路径数量
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long  curSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        // 递归结束条件
        if (node == null)
            return 0;

        // 当前节点的路径和
        curSum += node.val;

        // 获取到达当前节点的路径和等于 targetSum 的路径数量
        int pathNum = prefixSumCount.getOrDefault(curSum - targetSum, 0);

        // 更新路径和 的数量, 当前路径和的数量如果本来就存在就 + 1 没有就是 0+1
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

        // 递归处理左右子树
        int res = pathNum + dfs(node.left, curSum, targetSum, prefixSumCount)
                + dfs(node.right, curSum, targetSum, prefixSumCount);

        // 回溯，移除当前路径和的数量
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);

        return res;
    }
}
