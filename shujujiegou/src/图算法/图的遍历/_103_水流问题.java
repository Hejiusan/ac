package 图算法.图的遍历;

import java.util.Scanner;

/**
 * https://kamacoder.com/problempage.php?pid=1175
 *
 * 现有一个 N × M 的矩阵，每个单元格包含一个数值，这个数值代表该位置的相对高度。矩阵的左边界和上边界被认为是第一组边界，而矩阵的右边界和下边界被视为第二组边界。
 *
 * 矩阵模拟了一个地形，当雨水落在上面时，水会根据地形的倾斜向低处流动，但只能从较高或等高的地点流向较低或等高并且相邻（上下左右方向）的地点。
 * 我们的目标是确定那些单元格，从这些单元格出发的水可以达到第一组边界和第二组边界。
 */
public class _103_水流问题 {
    /*
    思路：遍历每一个点，是否都能到达第一边界和第二边界
     */
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] grid = new int[n][m];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] chars = s.split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(chars[j]);
            }
        }

        // 遍历每一个点，看是否能同时到达第一组边界和第二组边界
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isResult(grid, i, j)) { // 从 点(i,j)出发进行深搜。能同时到达一、二边界
                    System.out.printf(i + " " + j);
                }
            }
        }
    }

    private static boolean isResult(int[][] grid, int x, int y) {
        boolean[][] visited = new boolean[n][m];
        // 深搜，将x,y出发 能到的节点都标记上。
        // 如果边界的点没有被标记，就说明走不到那
        dfs(grid, visited, x, y);
        boolean isFirst = false;
        boolean isSecond = false;

        // 以下就是判断x，y出发，是否到达第一组边界和第二组边界
        // 第一边界的上边
        for (int j = 0; j < m; j++) {
            if (visited[0][j]) {
                isFirst = true;
                break;
            }
        }
        // 第一边界的左边
        for (int i = 0; i < n; i++) {
            if (visited[i][0]) {
                isFirst = true;
                break;
            }
        }
        // 第二边界右边
        for (int j = 0; j < m; j++) {
            if (visited[n - 1][j]) {
                isSecond = true;
                break;
            }
        }
        // 第二边界下边
        for (int i = 0; i < n; i++) {
            if (visited[i][m - 1]) {
                isSecond = true;
                break;
            }
        }
        if (isFirst && isSecond) return true;
        return false;

    }

    private static void dfs(int[][] grid, boolean[][] visited, int x, int y) {

        if (visited[x][y]) return;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];
            if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) continue;
            if (grid[x][y] < grid[nextx][nexty]) continue; // 高度不合适

            dfs (grid, visited, nextx, nexty);
        }

    }

}
