package 二叉树.遍历;

/**
 * https://leetcode.cn/problems/invert-binary-tree/description/
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 也就是交换左右子节点
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        // 遍历二叉树, 交换左右节点
        traverse(root);
        return root;

    }

    /**
     * 遍历每个节点，让他的左右子节点交换下
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null){
            return;
        }
        // 交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 前序遍历
        traverse(root.left);
        traverse(root.right);
    }


    // 从分解问题的角度解
    class Solution2 {
        /**
         * invertTree 反转一个子树
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null){
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            // 然后交换左右子节点
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
