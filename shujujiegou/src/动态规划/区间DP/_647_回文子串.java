package 动态规划.区间DP;
/*
https://leetcode.cn/problems/palindromic-substrings/description/

给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
回文字符串 是正着读和倒过来读一样的字符串。
子字符串 是字符串中的由连续字符组成的一个序列。
 */
public class _647_回文子串 {
    /*
    dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
    递推关系：
        当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。
        当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况

        情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
        情况二：下标i 与 j相差为1，例如aa，也是回文子串
        情况三：下标：i 与 j相差大于1的时候， 收缩到 i+1 和 j-1 继续判

     */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        int res = 0;
        for (int len = 1; len <= s.length(); len++) {         // 区间长度
            for (int i = 0; i + len - 1 < s.length(); i++) { // 枚举起点
                int j = i + len - 1;                 // 区间终点
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 1) { // 情况一 和 情况二
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { // 情况三
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }
}
