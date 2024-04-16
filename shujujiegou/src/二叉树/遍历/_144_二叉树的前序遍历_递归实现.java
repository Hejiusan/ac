package 二叉树.遍历;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 * 递归：
 * 一棵二叉树的前序遍历结果 = 根节点 + 左子树的前序遍历结果 + 右子树的前序遍历结果。
 */
public class _144_二叉树的前序遍历_递归实现 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraversal(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraversal(root.right));

        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
