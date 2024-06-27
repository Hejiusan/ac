package hot100.二叉树;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
 * 平衡二叉搜索树。
 * 平衡二叉树：是指该树所有节点的左右子树的深度相差不超过 1。
 * 二叉搜索树(BST)：左子树上所有节点的值均小于它的根节点的值；右子树上所有节点的值均大于它的根节点的值；
 */
public class _108_将有序数组转换为二叉搜索树 {
    /*
    BST 的中序遍历结果是有序的（升序）。
    也就是将 中序遍历 转为BST
    选择中间的节点作为根节点，那么构造出的二叉树一定是平衡的
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return builder(nums, 0, nums.length - 1);
    }

    /**
     * 将中序遍历结果构造出二叉树
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode builder(int[] nums, int left, int right) {
        // base case
        if (left > right)   return null;

        int mid = (left + (right - left)) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // 再分别构造左右子树
        node.left = builder(nums, left, mid - 1);
        node.right = builder(nums, mid + 1, right);
        return node;
    }
}
