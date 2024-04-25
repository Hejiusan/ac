package 二叉树.构造二叉树;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        // base case
        if (pStart > pEnd) {
            return null;
        }

        // root 节点对应的值就是后序遍历数组的第一个元素
        int rootVal = postorder[pEnd];
        // 根节点对应的索引
        Integer index = valToIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - iStart;
        int rightSize = iEnd - index;
        root.left = build(inorder, iStart, index - 1, postorder, pStart, pStart+leftSize -1);
        root.right = build(inorder, index+1, iEnd, postorder, pStart+leftSize, pEnd-1);
        return root;
    }
}
