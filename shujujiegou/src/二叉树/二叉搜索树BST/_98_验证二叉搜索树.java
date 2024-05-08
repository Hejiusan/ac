package 二叉树.二叉搜索树BST;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class _98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return traverseIsValidBST(root, null, null);
    }

    /**
     * 对于一个根节点，不仅要让他的左右孩子节点符合左小右大的原则，
     * 更要满足整个左子树都要小于root.val 整个右子树都要大于root.val
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean traverseIsValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root== null) return true;

        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;   // 不满足左边的小
        if (max != null && root.val >= max.val) return false;   // 不满足右边的大

        // 限定左子树的最大值是 root.val, 右子树的最小值是root.val
        // 左子树的值要小于根 右子树的值要大于根
        return traverseIsValidBST(root.left, min, root) && traverseIsValidBST(root.right, root, max);
    }
}
