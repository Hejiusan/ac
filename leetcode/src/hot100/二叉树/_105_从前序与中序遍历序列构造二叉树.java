package hot100.二叉树;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    // 存储中序遍历到索引的映射
    HashMap<Integer, Integer> volToIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < preorder.length; i++) {
            volToIndex.put(inorder[i], i);
        }

        return build (preorder, 0, preorder.length - 1, inorder, 0 , inorder.length - 1);

    }

    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // 结束条件
        if (pStart > pEnd){
            return null;
        }

        // 找到根节点
        int rootVal = preorder[pStart];
        // rootVal 在中序遍历数组中的索引
        int index = volToIndex.get(rootVal);
        int leftSize = index - iStart; //这就是左子树的长度
        TreeNode root = new TreeNode(inorder[index]);
        // 左子树 前序遍历 根左右； 中序遍历 左根右
        root.left = build(preorder, pStart + 1, pStart + leftSize, inorder, iStart, index - 1);
        root.right = build(preorder,leftSize + pStart + 1, pEnd, inorder, index + 1, iEnd);
        return root;

    }
}
