package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/distinct-subsequences/description/
 *
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
 */
public class _115_不同的子序列 {
    /*
    dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
    两种递推来源
    （1）s[i - 1] 与 t[j - 1]相等, 匹配成功，继续收缩。不用+1.因为不确定这就是满足的一种情况
        用s[i - 1]来匹配:   dp[i][j] = dp[i-1][j-1]
        不用s[i - 1]来匹配  dp[i][j] = dp[i - 1][j]      s中满足t的子序列是多个，可以收缩
            例如：s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
            当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
    （2）s[i - 1] 与 t[j - 1] 不相等  就是s收缩
        dp[i][j] = dp[i - 1][j]

     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 初始化, t为空时，s中一定包含一个为空的子序列，个数为1
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
