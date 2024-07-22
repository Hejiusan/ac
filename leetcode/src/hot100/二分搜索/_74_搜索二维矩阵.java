package hot100.二分搜索;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class _74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;  // m是行数  也就是一列有多少个元素
        int n = matrix[0].length;   // n是列数，代表了一行的数量
        /*
        每行的第一个都大于上一行的最后那个，那么把矩阵拉成一维的话 其实也是一个递增序列
        那么如何去将这个一维的索引映射到原二维矩阵呢？
        行列转换:
            假设一维数组的当前索引为mid
            由于每行有 n 个元素，所以用 mid / n 可以得到当前元素所在的行
            每行n个元素往后拼接，n个一循环。那么使用mid % n得到的余数就是他所在行多出的数量也就是所在的列
            通过 mid / n 计算行位置 row，通过 mid % n 计算列位置 col。
         */
        int low = 0;
        int high = m*n-1;
        while (low <= high){
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
