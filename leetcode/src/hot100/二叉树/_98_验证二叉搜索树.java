package hot100.二叉树;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class _98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return traverseIsValidBST(root, null, null);
    }
    private boolean traverseIsValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null)   return true;

        // 所有右子树节点的值必须大于该节点的值。
        // 这里其实是 root.right.value <= root.val 表明不合法
        if (min != null && root.val <= min.val) return false;

        // 所有左子树节点的值必须小于该节点的值。
        if (max != null && root.val >= max.val) return false;

        // 限定左子树的最大值是 root.val, 右子树的最小值是 root.val
        // 递归检查左子树, 当前节点的值将成为 max 参数
        boolean verify_left = traverseIsValidBST(root.left, min, root);
        // 右子树的所有值都必须大于当前节点的值。
        boolean verify_right = traverseIsValidBST(root.right, root, max);
        return verify_left && verify_right;

    }
}
