package hot100.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 1
 * 1 1
 * 1 2 1
 *
 */
public class _118_杨辉三角 {
    /*
    dp[i][j]: 表示第i行第j列的元素值
    状态转移：由左上和上方求和（扭一下） ==> dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
     */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        Integer[][] dp = new Integer[numRows][];
        // 遍历每一行
        for (int i = 0; i < numRows; i++) {
            // 初始化当前行
            dp[i] = new Integer[i + 1];
            // 初始化，每行的第一个数和最后一个数为1
            dp[i][0] = dp[i][i] = 1;
            // 计算中间元素
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for (Integer[] rows : dp) {
            res.add(Arrays.asList(rows));
        }

        return res;
    }


}
