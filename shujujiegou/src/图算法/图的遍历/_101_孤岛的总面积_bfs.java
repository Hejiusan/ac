package 图算法.图的遍历;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://kamacoder.com/problempage.php?pid=1173
 *
 * 给定一个由 1（陆地）和 0（水）组成的矩阵，岛屿指的是由水平或垂直方向上相邻的陆地单元格组成的区域，且完全被水域单元格包围。
 * 孤岛是那些位于矩阵内部、所有单元格都不接触边缘的岛屿。
 * 现在你需要计算所有孤岛的总面积，岛屿面积的计算方式为组成岛屿的陆地的总数。
 */
public class _101_孤岛的总面积_bfs {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;
    static int m;

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

        // 标记所有与边缘连接的岛屿
        // 因为没有变量接收，所以在求总面积的时候，可以排除掉这些边缘链接的岛屿
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                bfs(grid, visited, i, 0);
            }
            if (grid[i][m - 1] == 1 && !visited[i][m - 1]) {
                bfs(grid, visited, i, m - 1);
            }
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                bfs(grid, visited, 0, j);
            }
            if (grid[n - 1][j] == 1 && !visited[n - 1][j]) {
                bfs(grid, visited, n - 1, j);
            }
        }
        // 在遍历岛屿时，因为上面边缘岛屿已经走过了一次，所以都被visited标记过了
        int totalArea = 0;
        // 计算所有孤岛的面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    totalArea += bfs(grid, visited, i, j);
                }
            }
        }
        System.out.println(totalArea);
    }

    private static int bfs(int[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        Queue<int[]> pq= new LinkedList<>();
        pq.offer(new int[]{x,y});
        int area = 1;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            for (int i = 0; i < 4; i++) {
                int a = cur_x +dx[i];
                int b = cur_y +dy[i];
                if (a>=0 && a<n && b>=0 &&b<m && !visited[a][b] && grid[a][b] == 1){
                    // 相连的岛屿 就加进去队列
                    pq.offer(new int[]{a, b});
                    visited[a][b] = true;
                    area++;
                }
            }

        }
        return area;
    }
}
