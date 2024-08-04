package hot100.多维DP;

/**
 * https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
public class _62_不同路径 {
    /*
    dp[i][j]: 表示从从起点触出发，走到（i，j）的路径数量
    状态转移：
        只能由他的上方和左方走来
        dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
