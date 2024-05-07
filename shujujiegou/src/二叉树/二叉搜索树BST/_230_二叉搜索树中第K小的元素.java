package 二叉树.二叉搜索树BST;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * BST 的中序遍历结果是有序的（升序）。
 */
public class _230_二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    private void traverse(TreeNode root, int k) {
        if (root == null){
            return;
        }
        traverse(root.left, k);
        rank++; // 当前元素所在位置
        if (k == rank){
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    /**
     * 如果修改 trueNode的定义
     * class TreeNode {
     *     int val;
     *     // 以该节点为根的树的节点总数
     *     int size;
     *     TreeNode left;
     *     TreeNode right;
     * }
     * 可以将复杂度又O(N) 降低到logN
     * 比如说你让我查找排名为 k 的元素，当前节点知道自己排名第 m，那么我可以比较 m 和 k 的大小：
     * 1、如果 m == k，显然就是找到了第 k 个元素，返回当前节点就行了。
     *
     * 2、如果 k < m，那说明排名第 k 的元素在左子树，所以可以去左子树搜索第 k 个元素。
     *
     * 3、如果 k > m，那说明排名第 k 的元素在右子树，所以可以去右子树搜索第 k - m - 1 个元素。
     */
}
