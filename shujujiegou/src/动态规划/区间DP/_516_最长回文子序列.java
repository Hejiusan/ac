package 动态规划.区间DP;

/**
 * https://leetcode.cn/problems/longest-palindromic-subsequence/description/
 * <p>
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class _516_最长回文子序列 {
    /*
    dp[i][j]: [i,j]区间内最长的回文子序列长度
    递推关系：
        如果s[i] == s[j] ==> dp[i][j] = dp[i+1][j-1] + 2
        不相等 == 》 收缩一侧
            dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        // 初始化 如果区间长度为1 ，那么回文长度就是1
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= s.length(); len++) {         // 区间长度
            for (int i = 0; i + len - 1 < s.length(); i++) { // 枚举起点
                int j = i + len - 1;                 // 区间终点

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
