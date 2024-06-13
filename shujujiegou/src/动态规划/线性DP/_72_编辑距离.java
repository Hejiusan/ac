package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/edit-distance/description/
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class _72_编辑距离 {
    /*
    dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
    if (word1[i - 1] == word2[j - 1])
        不操作  dp[i][j] = dp[i-1][j-1]
    if (word1[i - 1] != word2[j - 1])
        增: 增本质就是删，word1增加一个元素 等价于 word2删掉一个元素
            ==> dp[i][j] = dp[i][j-1] + 1
        word1 = "ad" ，word2 = "a"，word1删除元素'd' 和 word2添加一个元素'd'，变成word1="a", word2="ad"， 最终的操作数是一样！
        删: word1 删除一个元素
             == 》 dp[i][j] = dp[i-1][j] + 1
        换: word1中替换word1[i - 1]，使其与word2[j - 1]，进行了一次替换操作
            使得 word1[i - 1] == word2[j - 1] ==》dp[i][j] = dp[i-1][j-1] + 1

     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
