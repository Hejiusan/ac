package hot100.二叉树;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 */
public class _236_二叉树的最近公共祖先 {
    /*
    深度尽可能大，也就是要找p、q最近的那个祖先
    递归函数输入 root、p、q
    共三种情况
    1、如果p和q都在以root为根节点的树中，那么最近公共祖先节点就是 root
    2、如果p、q都不在，就返回null
    3、如果只有一个节点在root为根节点的树中，则返回该节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束条件
        if (root == null)   return null;
        if (root == p || root == q) return root;

        //如果根节点是祖先，有没有更近的祖先呢。看他们的左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况 1
        if (left != null && right != null) {
            return root;
        }
        // 情况 2
        if (left == null && right == null) {
            return null;
        }
        // 情况 3
        return left == null ? right : left;

    }
}
