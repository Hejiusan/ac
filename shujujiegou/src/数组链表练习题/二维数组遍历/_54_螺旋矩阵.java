package 数组链表练习题.二维数组遍历;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/description/
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class _54_螺旋矩阵 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];    // 标记被访问过的点
        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}; //四个方向
        for (int x = 0, y = 0, k = 1, d = 0; k <= n * m; k++) { // k从1开始 共n*m个数
            res.add(matrix[x][y]);
            visited[x][y] = true;
            //记录变化的坐标
            int a = x + dx[d], b = y + dy[d];
            //判断是否走到头了  已经被访问过的点要记录下来，遇到说明要转向了
            if (a < 0 || a >= m || b < 0 || b >= n || visited[a][b]) {
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

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);
    }
}
