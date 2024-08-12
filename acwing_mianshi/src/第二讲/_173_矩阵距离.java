package 第二讲;

import java.util.*;

public class _173_矩阵距离 {
    /*
    求每个点到最近的1的曼哈顿距离构成的矩阵
    思路：
        因为矩阵中为1的格子距离为0 ，把这些1 保存下来
        然后从 所有的 1 出发去进行宽搜。就能一步步找到 距离为1的格子 为2 的格子。。。
     */
    static final int N = 1010; // 由于Java中不能使用1e3+10直接定义数组大小，我们定义为1010
    static int n, m;
    static char[][] g = new char[N][N];
    static int[][] dist = new int[N][N];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') {
                    queue.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = t[0] + dx[i], y = t[1] + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= m || dist[x][y] != -1) {
                    continue;
                }
                dist[x][y] = dist[t[0]][t[1]] + 1;
                queue.add(new int[]{x, y});
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            g[i] = line.toCharArray();
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(dist[i][j]);
            }
            System.out.println();
        }
    }
}
