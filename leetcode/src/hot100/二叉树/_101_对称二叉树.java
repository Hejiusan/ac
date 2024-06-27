package hot100.二叉树;

/**
 * https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class _101_对称二叉树 {
    /*
    左子树和柚子树镜像
    需要满足俩条件：
        两个根节点的值相同
        每个树的左右子树也镜像对称
     */

    public boolean isSymmetric(TreeNode root) {
        boolean isTrue = check(root.left, root.right);
        return isTrue;
    }

    /**
     * 递归检测左右子树是否镜像对称
     *    两个根节点的值相同
     *    每个树的左右子树也镜像对称
     * @param left
     * @param right
     * @return
     */
    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 走过了上面的判断 说明肯定不是全为null
        if (left == null || right == null) {
            return false;
        }
        // 左右根节点值相同，且他们的左右子节点也得check
        return (left.val == right.val) && check(left.left, right.right) && check(left.right, right.left);
    }
}
