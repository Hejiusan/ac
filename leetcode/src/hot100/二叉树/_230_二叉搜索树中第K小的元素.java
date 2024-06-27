package hot100.二叉树;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class _230_二叉搜索树中第K小的元素 {
    /*
    二叉搜索树中序遍历的结果会是一个升序序列，从而可以确定第K小的元素
     */
    int rank = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k){
        // 中序遍历，直到第k个数
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null)   return ;

        traverse(root.left, k);
        rank++;
        if (rank == k){
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
