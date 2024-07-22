package hot100.二叉树;

import hot100.链表.ListNode;
import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class _114_二叉树展开为链表 {
    /*
    1、将 root 的左子树和右子树拉平。
    2、将 root 的右子树接到左子树下方，然后将整个左子树作为右子树。
     */
    /**
     * 递归拉平子树
     * @param root
     */
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;
        // 先递归拉平左右子树
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;

        //将 root 的右子树接到左子树下方，然后将整个左子树作为右子树。
        root.left = null;
        root.right = left;
        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        // 遍历新的右子树（即原左子树），找到其末端
        while (p.right != null) {
            p = p.right;
        }
        // 再将原右子树接在新右子树右端
        p.right = right;
    }
}
