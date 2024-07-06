package 图算法.图的遍历;

import java.util.Scanner;

/**
 * https://kamacoder.com/problempage.php?pid=1172
 *
 * 给定一个由 1（陆地）和 0（水）组成的矩阵，计算岛屿的最大面积。岛屿面积的计算方式为组成岛屿的陆地的总数。
 * 岛屿由水平方向或垂直方向上相邻的陆地连接而成，并且四周都是水域。你可以假设矩阵外均被水包围。
 */
public class _100_岛屿的最大面积 {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;
    static int m;
    static int res = 0;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // Consume the newline
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] chars = s.split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(chars[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count = 1;
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                    res = Math.max(res, count); // 更新最大面积
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {   // 四个方向
            int a = x + dx[i];
            int b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m)   // 越界
                continue;
            if (!visited[a][b] && grid[a][b] == 1) {
                count++;
                visited[a][b] = true;
                dfs(grid, visited, a, b);
            }
        }

    }
}
