package 二叉树.遍历;

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 通过后序遍历优化。
 */
public class _543_二叉树的直径 {

    // 记录最大直径的长度
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序位置，顺便计算最大直径
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);    // 返回子树的最大深度

        return 1 + Math.max(leftMax, rightMax);
    }
}
