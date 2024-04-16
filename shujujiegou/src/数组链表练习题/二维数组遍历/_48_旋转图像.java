package 数组链表练习题.二维数组遍历;

/**
 * https://leetcode.cn/problems/rotate-image/description/
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class _48_旋转图像 {
    // 将二维矩阵原地顺时针旋转 90 度
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
