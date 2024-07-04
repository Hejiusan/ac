package hot100.二叉树;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class _104_二叉树的最大深度 {
    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null)   return;
        depth++;    // 往下遍历了 深度+1
        if (root.left == null && root.right == null){
            res = Math.max(res, depth);     // 更新最大深度
        }
        // 遍历二叉树  这里采用前序遍历
        traverse(root.left);
        traverse(root.right);
        // 复原更改
        depth--;

    }
}
