package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/unique-paths/description/
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class _62_不同路径 {
    // 机器人从(0 , 0) 位置出发，到(m - 1, n - 1)终点。
    // dp[i][j]：从起点出发走到（i，j）的路径
    // dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 两条路走过来 上或者左
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        // dp数组初始化
        // (0, 0)的位置到(i, 0)的路径只有一条  同理 从（0,0）到（0，j）的路径也只有一条 一路往下/往左
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
