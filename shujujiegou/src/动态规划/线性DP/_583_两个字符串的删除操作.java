package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 *
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 */
public class _583_两个字符串的删除操作 {
    /*
    dp[i][j]: 以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
    递推关系：
    当word1[i - 1] 与 word2[j - 1]相同的时候
        dp[i][j] = dp[i - 1][j - 1];
    当word1[i - 1] 与 word2[j - 1]不相同的时候
        细分为三种情况
        因为要删掉一个字符，进行了一次操作，操作数+1
        1、删word1，dp[i][j] = dp[i - 1][j] + 1;
        2、删word2：dp[i][j] = dp[i][j - 1] + 1;
        3、同时删：  dp[i][j] = dp[i - 1][j - 1] + 2;  因为一步删一个字符，所以得删两次
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
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
