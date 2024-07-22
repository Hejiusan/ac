package 图算法.图的遍历;

import java.util.*;

/**
 * https://kamacoder.com/problempage.php?pid=1176
 *
 * 给定一个由 1（陆地）和 0（水）组成的矩阵，你最多可以将矩阵中的一格水变为一块陆地，在执行了此操作之后，矩阵中最大的岛屿面积是多少。
 *
 * 岛屿面积的计算方式为组成岛屿的陆地的总数。岛屿是被水包围，并且通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设矩阵外均被水包围。
 */
public class _104_建造最大岛屿 {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;
    static int m;

    static Map<Integer, Integer> areaMap = new HashMap<>();
    /*
    1.	遍历矩阵，使用 DFS 或 BFS 找到所有的岛屿并计算它们的面积，同时记录每个岛屿的唯一标识符和面积。
	2.	记录岛屿之间的连接关系，即每个水格子可以连接到的岛屿。
	3.	计算可能的最大岛屿面积，假设我们将每个水格子变成陆地，然后通过这个水格子连接周围的岛屿，计算出新的岛屿面积，并记录最大值。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // Consume the newline
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] chars = s.split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(chars[j]);
            }
        }

        int res = largestIsland(grid);
        System.out.println(res);

    }

    private static int largestIsland(int[][] grid) {
        int[][] id = new int[n][m]; // id 数组标记每个格子所属的岛屿
        int islandId = 2; // 从 2 开始，因为 0 表示水，1 表示陆地
        int maxArea = 0;

        // Step 1: 遍历找出所有的岛屿，以及他们的面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && id[i][j] == 0) {
                    int area = dfs(grid, id, i, j, islandId);
                    areaMap.put(islandId, area);
                    maxArea = Math.max(maxArea, area);
                    islandId++;
                }
            }
        }
        // Step 2: 遍历翻转每一个水格子，重新计算最大面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenIslands = new HashSet<>(); // 记录当前水格子周围已经遇到过的岛屿的标识符。
                    int newArea = 1; // 因为是翻了一个水格子变成岛，所以面积初始化就有1
                    // 看这个新翻的岛屿四周有没有岛屿
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m && id[ni][nj] > 1) {
                            int neighborIslandId = id[ni][nj];
                            if (!seenIslands.contains(neighborIslandId)) {  // 防止重复计算了遇到的岛屿
                                newArea += areaMap.get(neighborIslandId);
                                seenIslands.add(neighborIslandId);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int[][] id, int x, int y, int islandId) {
        int area = 1;
        id[x][y] = islandId;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && id[nx][ny] == 0) {
                area += dfs(grid, id, nx, ny, islandId);
            }
        }
        return area;

    }
}
