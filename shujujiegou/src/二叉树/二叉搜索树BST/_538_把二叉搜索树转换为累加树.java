package 二叉树.二叉搜索树BST;

/**
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class _538_把二叉搜索树转换为累加树 {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    int sum = 0;

    /**
     * 改变一下递归顺序就变成了 降序排序
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null){
            return;
        }
        // 先递归遍历右子树
        traverse(root.right);
        // 中序遍历当前节点 代码位置
        //  因为递归会进到最下面再往上 所以当前节点就会统计它下面的子树的和
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
