package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/is-subsequence/description/
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 */
public class _392_判断子序列 {
    /*
    dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
    判断 s 是不是 t的子序列 == 》 t 的长度一定是 大于等于 s

    if (s[i - 1] == t[j - 1])
        t中找到了一个字符在s中也出现了
    if (s[i - 1] != t[j - 1])
        相当于t要删除元素，继续匹配
     */
    public boolean isSubsequence(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        // 因为 i，j对应的是 i-1 和j-1  所以要小于等于
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if (dp[s.length()][t.length()] == s.length())
            return true;
        else
            return false;
    }
}
