package 第四讲;

/**
 * https://www.acwing.com/problem/content/28/
 * <p>
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * <p>
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * <p>
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 */
public class _30_正则表达式匹配 {
    /*
    dp[i][j] 表示字符串 s 的前 i 个字符和模式 p 的前 j 个字符是否能匹配。
    初始化：dp[0][0] = true，因为两个空字符串是可以匹配的。初始化其他的边界条件，如模式以 '*' 开头的情况。
    状态转移：
        如果 p[j-1] 是普通字符或者 '.'，则 dp[i][j] 依赖于 dp[i-1][j-1]，同时需要 s[i-1] 和 p[j-1] 相匹配。
		如果 p[j-1] 是 '*'，则有两种情况：
		    1.	'*' 表示前面字符的重复 0 次，此时 dp[i][j] = dp[i][j-2]。
	        2.	'*' 表示至少重复 1 次，此时需要 s[i-1] 匹配 p[j-2]，且 dp[i][j] = dp[i-1][j]。
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始化
        dp[0][0] = true; // 两个空字符串能够匹配
        for (int j = 2; j <= n; j++) {
            // 如果是字符和'*'成对出现，可以消去字符和'*'
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];
        }

        // 填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') {
                    // '*' 匹配 0 次或多次的情况
                    // （matches(s, p, i, j-1) && dp[i-1][j]） 处理 '*' 匹配至少 1 次的情况
                    dp[i][j] = dp[i][j-2] || (matches(s, p, i, j-1) && dp[i-1][j]);
                } else {
                    // 普通字符或 '.'
                    dp[i][j] = matches(s, p, i, j) && dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 用于匹配当前字符 (匹配的是单个字符) 是否匹配，相同字符或者一个字符对应'.' 都可以匹配
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    private boolean matches(String s, String p, int i, int j) {
        return p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1);
    }
}
