package hot100.多维DP;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个字符串 s，找到 s 中最长的 回文子串
 * 。
 */
public class _5_最长回文子串 {
    /*
    对于一个回文子串而言(长度大于2)，将首尾两字母去除后，它还应该是一个回文子串
    dp[i][j]: s[i~j]是否为回文串
    状态转移：
        dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int left = 0, right = 0, res = 0;   // 记录左右边界和 右-左的长度
        boolean[][] dp = new boolean[len][len];
//        // 初始化  所有长度为1的子串都是回文串
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
        /*
        直接正向或者反向遍历一次，然后移动j相当于构造了一个字串； 这里是反向遍历
        递推过程：i，j 相等的时候，是序列长度为1或2的时候，或者子串dp[i+1][j-1]为true
         */
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                //如果j - i <= 1，必是回文串 ;  i=j包含在循环里了，会被初始化赋值为true
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if(j-i>res){
                        res=j-i;//res记得也得更新！
                        left=i;
                        right=j;
                    }
                }
            }
        }
        // 通过left和right记录i、j 所以只需要一次substring
        return s.substring(left,right+1);//左闭右开
    }
}
