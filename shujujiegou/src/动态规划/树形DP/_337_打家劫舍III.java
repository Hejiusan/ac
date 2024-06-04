package 动态规划.树形DP;

/**
 * https://leetcode.cn/problems/house-robber-iii/description/
 * <p>
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
public class _337_打家劫舍III {
    /*
    如果抢了当前节点，两个孩子就不能动，如果没抢当前节点，就可以考虑抢左右孩子（注意这里说的是“考虑”）
    dp[i]:
     */
    public int rob(TreeNode root) {
        int[] result = dfs(root);   // 后序遍历，因为要进到里面 左右根
        return Math.max(result[0], result[1]);
    }

    // 返回一个长度为 2 的数组，分别表示盗取和不盗取以 node 为根的子树的最大金额
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int f = node.val + left[1] + right[1]; // 盗取该节点  那么孩子节点都不能拿了
        int g = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不盗取该节点，那么就可以（考虑）取左右两个孩子节点，也可以不取，所以这里和不取比较，求最大

        return new int[]{f, g};
    }
}


class TreeNode {
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
