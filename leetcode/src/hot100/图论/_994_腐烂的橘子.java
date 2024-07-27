package hot100.图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class _994_腐烂的橘子 {
    /*
	1.	初始化队列和计数器：
	•	遍历整个网格，将所有腐烂橘子的坐标加入队列，并记录新鲜橘子的数量。
	•	计数器 minutes 用于记录腐烂扩散所需的时间。
	2.	广度优先搜索（BFS）：
	•	每次从队列中取出腐烂橘子的坐标，检查其四个方向相邻的单元格。
	•	如果相邻单元格是新鲜橘子，将其腐烂，并将其加入队列，同时减少新鲜橘子的计数。
	3.	判断结果：
	•	如果所有新鲜橘子都已经腐烂，返回计数器 minutes。
	•	如果仍然存在新鲜橘子但队列已空，返回 -1，表示不可能腐烂完所有新鲜橘子。
     */
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> failOrange = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        int res = 0; // 初始化计时器
        // 遍历整个网格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是腐烂橘子，就会蔓延出去(BFS更适合)
                if (grid[i][j] == 2)
                    failOrange.offer(new int[]{i, j});   // 烂橘子坐标加入队列
                if (grid[i][j] == 1)
                    freshOranges++;    // 记录新鲜橘子的数量
            }
        }
        // 如果没有新鲜橘子，直接返回0
        if (freshOranges == 0) {
            return 0;
        }

        // 每次从队列中取出腐烂橘子的坐标，检查其四个方向相邻的单元格。(BFS模版)
        while (!failOrange.isEmpty()) {
            int size = failOrange.size();
            boolean hasNewRotten = false;
            for (int i = 0; i < size; i++) {
                int[] cur = failOrange.poll();
                int x = cur[0];
                int y = cur[1];
                // 四周蔓延
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    // 如果下一个格子是新鲜橘子，就被污染
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        failOrange.offer(new int[]{nx, ny});
                        freshOranges--;
                        hasNewRotten = true;    // 表示这一层有橘子被污染了
                    }
                }

            }
            // 所有的烂橘子同时都可以蔓延，所以得在第一个for循环外
            // hasNewRotten = true;   是为了防止在这一层没有橘子被污染也会+1
            if (hasNewRotten)
                res++;
        }
        return freshOranges == 0 ? res : -1;
    }
}