package hot100.多维DP;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class _64_最小路径和 {
    /*
    dp[i][j]：从起点出发，到（i, j）点的最小路径和
    状态转移：
        左方或者上方过来加上它本身
        grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        // base case
        if (n == 1 && m == 1) {
            return grid[0][0];
        }
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // 初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];

    }
}
