package hot100.矩阵;

public class _240_搜索二维矩阵II {
    /*
    Z字形搜索 = 》 斜着看他其实是右上角为根节点的一棵二叉搜索树
    1.	初始化指针：
	•	从矩阵的右上角开始，即初始化 row 为 0，col 为矩阵的列数减1。
	2.	搜索过程：
	•	如果当前元素等于目标值，返回 true。
	•	如果当前元素大于目标值，向左移动一列（col--）。
	•	如果当前元素小于目标值，向下移动一行（row++）。
	3.	停止条件：
	•	如果指针超出了矩阵的边界（row 超过最大行索引或 col 小于0），则返回 false。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 初始化右上角的那个点为根节点 
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) { // 大了就往左移一列
                col--;
            } else {    // 小了就往下走一行找更大的
                row++;
            }
        }

        return false;

    }
}
