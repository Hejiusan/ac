package hot100.多维DP;

/**
 * https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class _72_编辑距离 {
    /*
    dp[i][j]: 表示将word[1,i] 变成 word2[1,j]的最小操作次数
    状态转移：
        1、插入一个字符
            a中在i位置插入一个字符之后变得相同，说明没有添加前，word1的前i个和word2的前j-1个已经相同
            dp[i][j] = dp[i][j-1] + 1;
        2、删除一个字符
            word1在i位置删除一个字符后变得相同，说明word1的i-1个以及和word2的前j个相同
            dp[i][j] = dp[i-1][j] + 1
        3、替换一个字符
            替换一个字符后变得相同, 说明word1和word2的结尾字母不同，则看他们的倒数第二个
            dp[i][j] = dp[i-1][j-1] + 1;
        4、啥也不做, 直接比较倒数第二个
            dp[i][j] = dp[i-1][j-1]

     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][]dp = new int[m + 1][n + 1];
        //初始化
        for(int i = 1; i <= m; i++) dp[i][0] = i;  //a的前i个字母要和b的第0个字母进行比较，所以只能进行删除操作
        for(int i = 1; i <= n; i++) dp[0][i] = i;  //a的第0个字母要和b的前i个字母进行比较，所以只能进行增加也就是插入操作

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // 如果结尾元素相同，啥也不用做直接看倒数第二个位置
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {  // 不同 就看是要哪种操作方式，取最小值
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
