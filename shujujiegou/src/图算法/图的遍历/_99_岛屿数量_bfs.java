package 图算法.图的遍历;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://kamacoder.com/problempage.php?pid=1171
 * <p>
 * 给定一个由 1（陆地）和 0（水）组成的矩阵，你需要计算岛屿的数量。岛屿由水平方向或垂直方向上相邻的陆地连接而成，并且四周都是水域。你可以假设矩阵外均被水包围。
 */
public class _99_岛屿数量_bfs {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;
    static int m;
    static int res = 0;

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
                    res++; // 遇到没访问过的陆地，+1
                    bfs(grid, visited, i, j);

                }
            }
        }
        System.out.println(res);
    }

    private static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) {   // 四个方向
                int a = curX + dx[i];
                int b = curY + dy[i];

                if (a >= 0 && a < n && b >= 0 && b < m && !visited[a][b] && grid[a][b] == 1) {
                    queue.offer(new int[]{a, b});
                    visited[a][b] = true;
                }
            }
        }
    }
}
