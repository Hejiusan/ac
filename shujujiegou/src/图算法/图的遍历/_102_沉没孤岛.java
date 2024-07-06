package 图算法.图的遍历;

import java.util.Scanner;

/**
 * https://kamacoder.com/problempage.php?pid=1174
 *
 * 给定一个由 1（陆地）和 0（水）组成的矩阵，岛屿指的是由水平或垂直方向上相邻的陆地单元格组成的区域，
 * 且完全被水域单元格包围。孤岛是那些位于矩阵内部、所有单元格都不接触边缘的岛屿。
 *
 * 现在你需要将所有孤岛“沉没”，即将孤岛中的所有陆地单元格（1）转变为水域单元格（0）。
 */
public class _102_沉没孤岛 {
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int n,m;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] chars = s.split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(chars[j]);
            }
        }

        // 排除边缘的岛屿
        // 步骤一：
        // 从左侧边，和右侧边 向中间遍历
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][m - 1] == 1) dfs(grid, i, m - 1);
        }

        // 从上边和下边 向中间遍历
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j);
            if (grid[n - 1][j] == 1) dfs(grid, n - 1, j);
        }
        // 步骤二、步骤三
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) grid[i][j] = 0;
                if (grid[i][j] == 2) grid[i][j] = 1;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == n-1 && j == m -1)
                    System.out.print(grid[i][j]);
                else
                    System.out.printf(grid[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void dfs(int[][] grid,int x, int y) {
        grid[x][y] = 2;
        for (int i = 0; i < 4; i++) { // 向四个方向遍历
            int nextx = x + dx[i];
            int nexty = y + dy[i];
            // 超过边界
            if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) continue;
            // 不符合条件，不继续遍历
            if (grid[nextx][nexty] == 0 || grid[nextx][nexty] == 2) continue;
            dfs (grid, nextx, nexty);
        }
        return;
    }
}
