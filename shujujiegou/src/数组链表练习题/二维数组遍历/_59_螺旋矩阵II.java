package 数组链表练习题.二维数组遍历;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/description/
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 也就是蛇形矩阵
 */
public class _59_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}; //四个方向
        int[][] res = new int[n][n];
        for (int x = 0, y = 0, d = 0, k = 1; k <= n * n; k++) {
            res[x][y] = k;
            // 记录下一步坐标
            int a = x + dx[d], b = y + dy[d];
            // 是否需要转向 ==》 走到边了 或者走到已经走过的了
            if (a < 0 || a >= n || b < 0 || b >= n || res[a][b] > 0) {
                // 转向：也就是d从0-》1-》2-》3循环  可以通过取模来实现
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            // 更新坐标
            x = a;
            y = b;
        }
        return res;
    }

}
