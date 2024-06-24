package hot100.矩阵;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        /*
         定义方向数组: 因为方向是右-》下-》左-》上
         所以对应的顺序是 右 ==》 行不变列+1  下 =》 行+1列不变
         */
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        boolean[][] visited = new boolean[n][m];
        // 遍历矩阵进行填充
        for (int x = 0, y = 0, k = 1, d = 0; k <= n * m; k++) {
            res.add(matrix[x][y]);
            visited[x][y] = true;
            // 下一步的坐标
            int a = x + dx[d];
            int b = y + dy[d];
            // 如果越界了，或者已经走过了 就得拐弯
            if (a < 0 || a >= n || b < 0 || b >= m || visited[a][b]) {
                // 转向：也就是d从0-》1-》2-》3循环  可以通过取模来实现
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}
