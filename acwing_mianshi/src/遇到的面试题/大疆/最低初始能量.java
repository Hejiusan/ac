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

    private static int calculateMinimumHP(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1, 1 - grid[m-1][n-1]);

        // 初始化最后一列
        for (int i = m-2; i >= 0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - grid[i][n-1]);
        }

        // 初始化最后一行
        for (int j = n-2; j >= 0; j--) {
            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - grid[m-1][j]);
        }

        // 填充剩余的dp表
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int minEnergy = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, minEnergy - grid[i][j]);
            }
        }

        return dp[0][0];
    }
}
