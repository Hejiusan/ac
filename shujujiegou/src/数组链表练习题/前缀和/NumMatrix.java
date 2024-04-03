package 数组链表练习题.前缀和;

/**
 * matrix 二维前缀和
 */
public class NumMatrix {
    // preSum[i][j] matrix [0, 0, i-1, j-1] 的前缀和
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;    // m*n的矩阵
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和   以（0，0）为起点的区域
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    // 计算子矩阵[x1, y1, x2, y2]的前缀和
    public int sumRegion(int x1, int y1, int x2, int y2) {
        //
        return preSum[x2+1][y2+1] - preSum[x1][y2+1] - preSum[x2+1][y1] +
                preSum[x1][y1];
    }
}
