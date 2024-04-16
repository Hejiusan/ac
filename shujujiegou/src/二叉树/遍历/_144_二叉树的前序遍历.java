package 二叉树.遍历;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 */
public class _144_二叉树的前序遍历 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }
    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
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
