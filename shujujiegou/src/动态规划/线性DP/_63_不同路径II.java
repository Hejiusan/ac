package 动态规划.线性DP;

/**
 * https://leetcode.cn/problems/unique-paths-ii/description/
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class _63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        机器人从(0 , 0) 位置出发，到(m - 1, n - 1)终点。
        dp[i][j]：从起点出发走到（i，j）的路径
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 两条路走过来 上或者左
        考虑到遇到障碍，那么就把这条路径作废就是了 dp[i][j]保持0
         */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        // 数组初始化
        // 遇到障碍物说明这条路径走不通了，那么初始化就为0了，因为不是一条路径
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;  // 走不通
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
