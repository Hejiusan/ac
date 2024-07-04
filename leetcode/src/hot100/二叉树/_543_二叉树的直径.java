package hot100.二叉树;

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class _543_二叉树的直径 {

    int res = 0;

    /**
     * 最大长度为 root的左右子树最大深度相加
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;
        // 计算左右子树的最大深度
        int leftDepth = traverse(root.left);
        int rightDepth = traverse(root.right);
        res = Math.max(res, leftDepth + rightDepth);    // 更新最大直径
        // 返回当前节点的最大深度
        //假设当前节点是 node，它的左子树深度是 leftDepth，右子树深度是 rightDepth。
        // 那么当前节点的最大深度就是 max(leftDepth, rightDepth) + 1。
        // 因为他自己也要站一层
        return Math.max(leftDepth, rightDepth) + 1;

    }
}
