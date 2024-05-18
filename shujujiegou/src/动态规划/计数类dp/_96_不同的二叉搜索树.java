package 动态规划.计数类dp;

/**
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class _96_不同的二叉搜索树 {
    /**
     * dp[i]:
     * 状态转移方程： dp[i] += dp[j-1]*dp[i-j]
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int []dp = new int[n+1];  // 遍历从1到n组成的二叉搜索树的种类数量
        // 初始化
        dp[0] = 1;  // 空树也是一种
        // 遍历顺序
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
