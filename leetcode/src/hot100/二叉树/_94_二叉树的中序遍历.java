package hot100.二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class _94_二叉树的中序遍历 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root){
        if (root == null){
            return;
        }
        // 中序遍历  左 根 右
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}

