package hot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _51_N皇后 {
    List<List<String>> res = new LinkedList<>();

    /**
     * 输入棋盘边长n，返回所有合法的放置
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    /**
     * 遍历行从0开始
     * @param board
     * @param row
     */
    private void backtrack(List<String> board, int row) {
        // 结束条件

        int length = board.get(row).length();   // 当前行的元素数量
        // 遍历当前行的每一个位置
        for (int col = 0; col < length; col++) {
            // 做选择
            char[] rowChar = board.get(row).toCharArray();
        }
    }
}
