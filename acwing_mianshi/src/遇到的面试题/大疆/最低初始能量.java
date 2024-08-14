package 遇到的面试题.大疆;

import java.util.Scanner;

public class 最低初始能量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        String[] s = s1;
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int grid[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            s1 = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(s1[j]);
            }
        }
        int res = calculateMinimumHP(grid);
        System.out.println(res);
    }

    /*
    dp[i][j] 表示从点 (i, j) 到右下角 (m-1, n-1) 所需要的最小初始能量。这意味着，我们的DP表是从右下角向左上角计算的。
    状态转移：
        确保路径上任何点的能量都不会小于1。
        考虑每一点 (i, j)，你可以从这一点向右移动到 (i, j+1) 或向下移动到 (i+1, j)。因此，dp[i][j] 应该基于这两个可能的下一步的最小能量需求来计算。
        // 移动到的下一个位置我要找一个尽可能小的，所以求min
        dp[i][j] + grid[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1])
        假设有A点 grid(0,0)的值为1，下一步要要走到dp(0, 1) = 5 or dp(1, 0) = 4
        显然是往最小的走，我们要记住dp数组的定义，dp (i, j)是在当前点走到右下角所需要的最小能量
        那么我们走到 dp(1, 0)的时候至少有4点能量。所以我们在A点dp(0,0)时需要有 4 - 1 = 3的初始能量
        为啥是“-” 因为正值是相当于给我们补了能量，所以我们的初始能量需要减去补得部分，如果是负的，就得减去这么多，所以需要更大的初始能量，也就是变成加了

        dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - grid[i][j]) // 这里是确保每个点的能量最少为1，本质还是求min  只是为了确保不能出<1的点

     */
    public static int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // 因为需要从右下角往上推，所以初始化dp[m-1][n-1],
        // 前一步只有一点生命走到grid[m-1][n-1]  并且要保证 最小为 1
        dp[m-1][n-1] = Math.max(1,1 -grid[m-1][n-1]);
        // 还要初始化 下和右两条边
        // 最后一列
        for (int i = m-2; i >= 0; i--) {
            dp[i][n-1] = Math.max(1,dp[i+1][n-1] - grid[i][n-1]);
        }
        // 最后一行
        for (int i = n-2; i >= 0; i--) {
            dp[m-1][i] = Math.max(1,dp[m-1][i+1] - grid[m-1][i]);
        }
        // 计算状态
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - grid[i][j]);
            }
        }
        return  dp[0][0];
    }
}
