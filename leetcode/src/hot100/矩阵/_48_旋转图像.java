package hot100.矩阵;

/**
 * https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class _48_旋转图像 {
    /*
    旋转90° == 》
        先转置矩阵（行列互换，也就是沿左对角线翻转）
            将矩阵的第  i  行第  j  列元素变为第  j  行第  i  列元素。
        再翻转每一行
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 先转置矩阵
        // 在转置矩阵时，应该只遍历矩阵的一半（对角线以上或以下），否则会重新交换已经交换过的元素
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再反转每一行
        // 只遍历每行的一半元素，将每行的元素左右交换。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
